package com.example.ebicompany.nettyserver;

import io.netty.channel.Channel;

/**
 * Created by ebicompany on 9/3/14.
 */
public class ReferenceToChannels {
    //region statick variables
    public static Channel GUIChannel = null;
    public static Channel FPGAChannel = null;
    public static Channel IS2Channel = null;
    //endregion

    //region sync objects
    private static Object syncGUIChannel = new Object();
    private static Object syncFPGAChannel = new Object();
    private static Object syncIS2Channel = new Object();
    //endregion

    //region static methods
    //endregion
}
