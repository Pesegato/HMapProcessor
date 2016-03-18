package pesegato;

import pesegato.processors.ClampVerticalHeightProcessor;
import pesegato.processors.FixedHeightProcessor;
import pesegato.masks.HorizontalMask;
import pesegato.masks.VerticalMask;
import pesegato.masks.BooleanORMask;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.system.JmeContext;
import com.jme3.terrain.geomipmap.TerrainQuad;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;
import pesegato.masks.NoMask;
import pesegato.processors.SmoothProcessor;

public class TweakScene extends SimpleApplication {

    public static void main(String args[]) {
        TweakScene tp = new TweakScene();
        tp.setShowSettings(false);
        tp.start(JmeContext.Type.Headless);
    }

    @Override
    public void simpleInitApp() {

        Spatial sceneModel=assetManager.loadModel("Scenes/lev1.j3o");
        
        TerrainQuad terrain=(TerrainQuad)((Node)sceneModel).getChild(0);
        
        /*Material mat_terrain = new Material(assetManager,
                "Common/MatDefs/Terrain/Terrain.j3md");

        mat_terrain.setTexture("Alpha", assetManager.loadTexture(
                "Textures/Terrain/splat/alphamap.png"));

        Texture grass = assetManager.loadTexture(
                "Textures/Terrain/splat/grass.jpg");
        grass.setWrap(WrapMode.Repeat);
        mat_terrain.setTexture("Tex1", grass);
        mat_terrain.setFloat("Tex1Scale", 64f);

        Texture dirt = assetManager.loadTexture(
                "Textures/Terrain/splat/dirt.jpg");
        dirt.setWrap(WrapMode.Repeat);
        mat_terrain.setTexture("Tex2", dirt);
        mat_terrain.setFloat("Tex2Scale", 32f);

        Texture rock = assetManager.loadTexture(
                "Textures/Terrain/splat/road.jpg");
        rock.setWrap(WrapMode.Repeat);
        mat_terrain.setTexture("Tex3", rock);
        mat_terrain.setFloat("Tex3Scale", 128f);
        float f[] = new float[1089];
        for (int i = 0; i < f.length; i++) {
            f[i] = 200;
        }
        HeightmapProcessor hmp = new HeightmapProcessor(f);
        hmp.setFilter(new BooleanORMask(
                new VerticalMask(1, true), new HorizontalMask(1, true),
                new VerticalMask(31, false), new HorizontalMask(31, false)));
        FixedHeightProcessor.fixedHeight(hmp, 0);

        float maxStep = 1.5f;

        hmp.setFilter(new VerticalMask(18, true));
        ClampVerticalHeightProcessor.towardSouth(hmp, maxStep);
        hmp.setFilter(new VerticalMask(16, false));
        ClampVerticalHeightProcessor.towardNorth(hmp, maxStep);
        hmp.setFilter(new HorizontalMask(18, true));
        ClampVerticalHeightProcessor.towardEast(hmp, maxStep);
        hmp.setFilter(new HorizontalMask(16, false));
        ClampVerticalHeightProcessor.towardWest(hmp, maxStep);
        
        hmp.setFilter(new VerticalMask(10, true));
        SmoothProcessor.smooth(hmp, 1, 5);

        hmp.finish(mat_terrain,"assets/Scenes/TestP.j3o", "myTerrain", 33, 33);//65, 513);*/
        System.out.println("Done!");
        System.exit(0);
    }
}
