package com.group1.inventorysystem;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * This class manages the images and assets.
 * 
 * @author Chris
 */
public class AssetManager {
    public enum Kinds {IMAGE, FONT};

    public AssetManager() {}

    /**
     * Translate the enum to a filepath name.
     * 
     * @param kind
     * @return
     * @throws Exception Raised when an unknown kind is passed.
     */
    private String getKind(Kinds kind) {
        switch (kind) {
            case IMAGE -> {return "images";}
            case FONT -> {return "fonts";}
            default -> {return "";}  // TODO: throw an exception instead.
        }
    }

    /**
     * This method builds the file path of the asset requested by the caller.
     * 
     * @param kind The kind of the asset.
     * @param name
     * @return 
     */
    private String getAsset(Kinds kind, String name) {
        return String.format(
            "%s/%s/%s",
                Info.ASSETS_PATH,
                this.getKind(kind),
                name
        );
    }
    
    public ImageIcon getPlaceholder() {
        return new ImageIcon(this.getAsset(Kinds.IMAGE, "placeholder.png"));
    }

    /**
     * Get an image icon from the assets.
     * @param filename The filename of the asset.
     * @return The image icon.
     */
    public ImageIcon getImageIcon(String filename) {
        return new ImageIcon(this.getAsset(Kinds.IMAGE, filename));
    }

    /**
     * Get an image from the assets.
     * @param filename The filename of the asset.
     * @return The image icon.
     */
    public Image getImage(String filename) {
        return new ImageIcon(this.getAsset(Kinds.IMAGE, filename)).getImage();
    }

    /**
     * Get an image icon from the filepath.
     * @param filename The filename of the asset.
     * @return The image icon.
     */
    public ImageIcon getExternalImageIcon(String filename) {
        return new ImageIcon(filename);
    }

    /**
     * Get a scaled version of an image icon from the assets.
     * @param filename The filename of the asset.
     * @param x The width of the icon.
     * @param y The length of the icon.
     * @return The image icon.
     */
    public ImageIcon getImageIcon(String filename, int x, int y) {
        ImageIcon img = new ImageIcon(this.getAsset(Kinds.IMAGE, filename));
        Image img_scaled = img.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
        return new ImageIcon(img_scaled);
    }
    
    /**
     * Get a scaled version of an image icon from the filepath.
     * @param filename The filename of the asset.
     * @param x The width of the icon.
     * @param y The length of the icon.
     * @return The image icon.
     */
    public ImageIcon getExternalImageIcon(String filename, int x, int y) {
        ImageIcon img = new ImageIcon(filename);
        Image img_scaled = img.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH);
        return new ImageIcon(img_scaled);
    }
}
