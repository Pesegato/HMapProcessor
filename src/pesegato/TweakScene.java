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
        
        Material mat_terrain = terrain.getMaterial();
        
        HeightmapProcessor hmp = new HeightmapProcessor(terrain);
        hmp.setFilter(new BooleanORMask(
                new VerticalMask(1, true), new HorizontalMask(1, true),
                new VerticalMask(255, false), new HorizontalMask(255, false)));
        FixedHeightProcessor.fixedHeight(hmp, 0);

        float maxStep = 5.5f;

        hmp.setFilter(new VerticalMask(30, true));
        ClampVerticalHeightProcessor.towardSouth(hmp, maxStep);
        hmp.setFilter(new VerticalMask(225, false));
        ClampVerticalHeightProcessor.towardNorth(hmp, maxStep);
        hmp.setFilter(new HorizontalMask(30, true));
        ClampVerticalHeightProcessor.towardEast(hmp, maxStep);
        hmp.setFilter(new HorizontalMask(225, false));
        ClampVerticalHeightProcessor.towardWest(hmp, maxStep);
        /*
        hmp.setFilter(new VerticalMask(10, true));
        SmoothProcessor.smooth(hmp, 1, 5);*/

        hmp.finish(mat_terrain,"assets/Scenes/Tweaked.j3o", "myTerrain", 65, 257);
        System.out.println("Done!");
        System.exit(0);
    }
}
