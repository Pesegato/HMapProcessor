
package pesegato;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.system.JmeContext;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;

public class TestProcessor extends SimpleApplication{

    public static void main(String args[]){
        TestProcessor tp=new TestProcessor();
        tp.setShowSettings(false);
        tp.start(JmeContext.Type.Headless);
    }
    
    @Override
    public void simpleInitApp() {
        //Collection<com.jme3.renderer.Caps> caps = renderer.getCaps();
        //Logger.getLogger(TestProcessor.class.getName()).log(Level.INFO, "Capabilities: {0}", caps.toString());
        
        //HeightmapProcessor hmp=new HeightmapProcessor(assetManager, "Textures/Terrain/splat/mountains512.png");
    /** 1. Create terrain material and load four textures into it. */
    Material mat_terrain = new Material(assetManager, 
            "Common/MatDefs/Terrain/Terrain.j3md");
 
    /** 1.1) Add ALPHA map (for red-blue-green coded splat textures) */
    mat_terrain.setTexture("Alpha", assetManager.loadTexture(
            "Textures/Terrain/splat/alphamap.png"));
 
    /** 1.2) Add GRASS texture into the red layer (Tex1). */
    Texture grass = assetManager.loadTexture(
            "Textures/Terrain/splat/grass.jpg");
    grass.setWrap(WrapMode.Repeat);
    mat_terrain.setTexture("Tex1", grass);
    mat_terrain.setFloat("Tex1Scale", 64f);
 
    /** 1.3) Add DIRT texture into the green layer (Tex2) */
    Texture dirt = assetManager.loadTexture(
            "Textures/Terrain/splat/dirt.jpg");
    dirt.setWrap(WrapMode.Repeat);
    mat_terrain.setTexture("Tex2", dirt);
    mat_terrain.setFloat("Tex2Scale", 32f);
 
    /** 1.4) Add ROAD texture into the blue layer (Tex3) */
    Texture rock = assetManager.loadTexture(
            "Textures/Terrain/splat/road.jpg");
    rock.setWrap(WrapMode.Repeat);
    mat_terrain.setTexture("Tex3", rock);
    mat_terrain.setFloat("Tex3Scale", 128f);
    float f[]=new float[1024];
    for (int i=0;i<f.length;i++)
        f[i]=100+i;
        HeightmapProcessor hmp=new HeightmapProcessor(assetManager, f,mat_terrain);
        FixedHeightProcessor.fixedHeight(hmp, 10);
        //FixedHeightProcessor2.fixedHeightNorth(hmp, 10, 0.5f);
        //FixedHeightProcessor.fixedHeightWest(hmp, 10, 0.5f);
        //FixedHeightProcessor.fixedHeightSouth(hmp, 10, 0.5f);
        //FixedHeightProcessor.fixedHeightEast(hmp, 10, 0.5f);
        hmp.finish("assets/Scenes/TestP.j3o", "myTerrain", 33, 33);//65, 513);
        System.out.println("Done!");
        System.exit(0);
    }
}
