
package pesegato;

import pesegato.masks.NoMask;
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

    public int size;
    private float hm[];
    
    HMProcessorMask mask;
    
    public HeightmapProcessor(float[] heightmapF){
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
    
    public HeightmapProcessor(AssetManager assetManager, String j3oFilePath){
        Node loadedNode = (Node)assetManager.loadModel(j3oFilePath);
        TerrainQuad terrain=(TerrainQuad) loadedNode.getChild("Terrain");
        size=terrain.getTotalSize();
        hm=terrain.getHeightMap();
        mask=new NoMask();
    }
    
    public HeightmapProcessor(TerrainQuad terrain){
        size=terrain.getTotalSize();
        hm=terrain.getHeightMap();
        mask=new NoMask();
    }
    
    public HeightmapProcessor(Texture heightMapImage){
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
    
    public void finish(Material matTerrain, String path, String name, int patchsize, int totalsize){
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
}