
package pesegato;

import com.jme3.asset.AssetManager;
import com.jme3.export.binary.BinaryExporter;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.terrain.heightmap.AbstractHeightMap;
import com.jme3.terrain.heightmap.ImageBasedHeightMap;
import com.jme3.terrain.heightmap.RawHeightMap;
import com.jme3.texture.Texture;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HeightmapProcessor {

    int size;
    private float hm[];
    Material matTerrain;
    private float grassScale = 64;
    private float dirtScale = 16;
    private float rockScale = 128;
    
    HMProcessorMask mask;
    
    public HeightmapProcessor(AssetManager assetManager, float[] heightmapF, Material mat){
        matTerrain=mat;
        AbstractHeightMap heightmap = null;
        try {
            heightmap = new RawHeightMap(heightmapF);
            this.size=heightmap.getSize();
            hm=heightmap.getHeightMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mask=new NoMask();
    }
    
    public HeightmapProcessor(AssetManager assetManager, String path){
        Texture heightMapImage = assetManager.loadTexture(path);
        matTerrain=new Material(assetManager, "Common/MatDefs/Terrain/TerrainLighting.j3md");
        matTerrain.setBoolean("useTriPlanarMapping", false);
        matTerrain.setBoolean("WardIso", true);
        matTerrain.setFloat("Shininess", 0);

        // ALPHA map (for splat textures)
        matTerrain.setTexture("AlphaMap", assetManager.loadTexture("Textures/Terrain/splat/alphamap.png"));

        // GRASS texture
        Texture grass = assetManager.loadTexture("Textures/Terrain/splat/grass.jpg");
        grass.setWrap(Texture.WrapMode.Repeat);
        matTerrain.setTexture("DiffuseMap", grass);
        matTerrain.setFloat("DiffuseMap_0_scale", grassScale);

        // DIRT texture
        Texture dirt = assetManager.loadTexture("Textures/Terrain/splat/dirt.jpg");
        dirt.setWrap(Texture.WrapMode.Repeat);
        matTerrain.setTexture("DiffuseMap_1", dirt);
        matTerrain.setFloat("DiffuseMap_1_scale", dirtScale);

        // ROCK texture
        Texture rock = assetManager.loadTexture("Textures/Terrain/splat/road.jpg");
        rock.setWrap(Texture.WrapMode.Repeat);
        matTerrain.setTexture("DiffuseMap_2", rock);
        matTerrain.setFloat("DiffuseMap_2_scale", rockScale);
        AbstractHeightMap heightmap = null;
        try {
            heightmap = new ImageBasedHeightMap(heightMapImage.getImage());
            heightmap.load();
            size=heightmap.getSize();
            hm=heightmap.getHeightMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mask=new NoMask();
    }
    
    public void setFilter(HMProcessorMask filter){
        this.mask=filter;
    }
    
    public float getHM(int row, int col){
        return hm[row*size+col];
    }

    public void setHM(int row, int col, float height){
        if (mask.mask(row, col))
            hm[row*size+col]=height;
    }
    
    public void finish(String path, String name, int patchsize, int totalsize){
        Node rootNode=new Node();
        TerrainQuad tq=new TerrainQuad("terraintest", patchsize, totalsize, hm);
        tq.setMaterial(matTerrain);
        rootNode.attachChild(tq);
        DirectionalLight light = new DirectionalLight();
        light.setDirection((new Vector3f(-0.5f, -1f, -0.5f)).normalize());
        rootNode.addLight(light);

        AmbientLight ambLight = new AmbientLight();
        ambLight.setColor(new ColorRGBA(1f, 1f, 0.8f, 0.2f));
        rootNode.addLight(ambLight);
        BinaryExporter exporter = BinaryExporter.getInstance();
        File file = new File(path);
        try {
            exporter.save(rootNode, file);
        } catch (IOException ex) {
        Logger.getLogger(HeightmapProcessor.class.getName()).log(Level.SEVERE, "Error: Failed to save game!", ex);
    }
    }
    
    class NoMask implements HMProcessorMask{

        public boolean mask(int row, int col) {
            return true;
        }
        
    }
}
