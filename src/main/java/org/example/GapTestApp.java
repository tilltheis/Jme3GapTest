package org.example;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

public class GapTestApp extends SimpleApplication {
    public static void main(String[] args) {
        GapTestApp app = new GapTestApp();

        AppSettings settings = new AppSettings(true);
        app.setSettings(settings);

        app.setShowSettings(false);

        app.start();
    }

    @Override
    public void simpleInitApp() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Box box = new Box(16, 0.1f, 16);
                Geometry geometry = new Geometry("", box);

                Material material = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
                material.setBoolean("UseMaterialColors", true);
                material.setColor("Diffuse", ColorRGBA.Red);

                geometry.setMaterial(material);
                geometry.setLocalTranslation(32 * x, 0, 32 * y);

                rootNode.attachChild(geometry);
            }
        }

        rootNode.addLight(
                new DirectionalLight(
                        new Vector3f(-0.1f, -1f, -0.1f).normalizeLocal(), new ColorRGBA(2f, 2f, 2f, 1f)));


        cam.setLocation(new Vector3f(-89.50687f, 106.29963f, -76.591995f));
        cam.setRotation(new Quaternion(0.20355059f, 0.36880204f, -0.08312156f, 0.9031295f));
    }
}
