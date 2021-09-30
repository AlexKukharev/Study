package mainPackage.window.adapters;

import mainPackage.Main;
import mainPackage.geometry.Building;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.swing.*;

class ProjectionsActionAdapterTest {

    @Test
    void act_mode0_axonometricDialogOpened() {
        Main.setFigure(new Building(1, 1, 1, 1));
        ProjectionsActionAdapter adapter = new ProjectionsActionAdapter(new JFrame(), (byte) 0);
        adapter.act();
        Assert.assertEquals(0, Main.getFigure().getProjectionPlane());
    }

    @Test
    void act_mode1_axonometricDialogOpened() {
        Main.setFigure(new Building(1, 1, 1, 1));
        ProjectionsActionAdapter adapter = new ProjectionsActionAdapter(new JFrame(), (byte) 1);
        adapter.act();
        Assert.assertEquals(1, Main.getFigure().getProjectionPlane());
    }

    @Test
    void act_mode2_axonometricDialogOpened() {
        Main.setFigure(new Building(1, 1, 1, 1));
        ProjectionsActionAdapter adapter = new ProjectionsActionAdapter(new JFrame(), (byte) 2);
        adapter.act();
        Assert.assertEquals(2, Main.getFigure().getProjectionPlane());
    }

    @Test
    void act_mode3_axonometricDialogOpened() {
        Main.setFigure(new Building(1, 1, 1, 1));
        ProjectionsActionAdapter adapter = new ProjectionsActionAdapter(new JFrame(), (byte) 3);
        Thread t = new Thread(adapter::act);
        t.start();
        while (adapter.axonometricParametersDialog == null)
            Thread.yield();
        Assert.assertNotNull(adapter.axonometricParametersDialog);
    }

    @Test
    void act_mode4_obliqueDialogOpened() {
        Main.setFigure(new Building(1, 1, 1, 1));
        ProjectionsActionAdapter adapter = new ProjectionsActionAdapter(new JFrame(), (byte) 4);
        Thread t = new Thread(adapter::act);
        t.start();
        while (adapter.obliqueParametersDialog == null)
            Thread.yield();
        Assert.assertNotNull(adapter.obliqueParametersDialog);
    }

    @Test
    void act_mode5_axonometricDialogOpened() {
        Main.setFigure(new Building(1, 1, 1, 1));
        ProjectionsActionAdapter adapter = new ProjectionsActionAdapter(new JFrame(), (byte) 5);
        Thread t = new Thread(adapter::act);
        t.start();
        while (adapter.perspectiveParametersDialog == null)
            Thread.yield();
        Assert.assertNotNull(adapter.perspectiveParametersDialog);
    }
}

