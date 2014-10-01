HMapProcessor
=============

There are tools that can sculpt a Terrain by hand (like SceneEditor); this instead is an API for programmatically alter the heightmap of a Terrain. For example, you can create  a randomly generated terrain that has a volcano on the north, a pear-shaped lake on the south and a road in between.

The core concepts
-----------------

You provide an initial HeightMap to the Heightmap processor, which apply a transformation and outputs the processed Terrain in .j3o format (so that you can use it as is or loat it on the SceneEditor for further manual editing).
The neat thing is that transformation can be chained together to create interesting combination! 

How to use a HeightmapProcessor
-------------------------------

We use here a basic HeightmapProcessor that sets the height to a fixed value.

        float f[] = new float[1089];
        for (int i = 0; i < f.length; i++) {
            f[i] = 200;
        }
        HeightmapProcessor hmp = new HeightmapProcessor(f);
        FixedHeightProcessor.fixedHeight(hmp, 22);


Regardless of the input, the Terrain output should be perfectly flat at the height 22. Awesome! But before you start throwing rotten eggs at me, please let me introduce…

Masks
-----

The Mask is basically an editing selection for the HeightmapProcessor: it allows or forbid the modification of subregions of the Terrain.
By default, the NoMask is applied (so that all the Terrain can be modified). Here we use a simple maks that allow modification only on the “western” area of the Terrain

        HeightmapProcessor hmp = new HeightmapProcessor(f);
        hmp.setFilter(new HorizontalMask(10, true));
        FixedHeightProcessor.fixedHeight(hmp, 0);


Boolean logic masks
-------------------

Masks can be combined together with boolean logic. In the next example, we create a mask that allow editing on the “north-west” area of the Terrain.

        HeightmapProcessor hmp = new HeightmapProcessor(f);
        hmp.setFilter(new BooleanANDMask(
                new VerticalMask(10, true), new HorizontalMask(10, true));
        FixedHeightProcessor.fixedHeight(hmp, 0);

The allowed boolean masks are:
AND
OR
NOT

???Processor
------------

We have talked about HeightmapProcessor for editing the heightmap of a Terrain. However, we could think of a heightmap as a “just a map”. For example, if I decide that “0” on the map is an empty space, “1” is a wall, “2” is a monster an so on, then the processor can be abused as a level editor.
