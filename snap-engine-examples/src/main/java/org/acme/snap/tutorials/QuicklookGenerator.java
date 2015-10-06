package org.esa.snap.tutorials;

import com.bc.ceres.core.ProgressMonitor;
import org.esa.snap.core.dataio.ProductIO;
import org.esa.snap.core.datamodel.Band;
import org.esa.snap.core.datamodel.Product;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
Example taken from the tutorial given at Sentinel-3 OLCI/SLSTR and MERIS/(A)ATSR workshop 2012.
See http://www.brockmann-consult.de/cms/web/beam/tutorials
 */
public class QuicklookGenerator {

    public static void main(String[] args) {
        try {
            Product product = ProductIO.readProduct(args[0]);
            Band band = product.getBand("radiance_13");
            BufferedImage rgbImage = band.createRgbImage(ProgressMonitor.NULL);
            ImageIO.write(rgbImage, "PNG", new File(product.getName() + ".png"));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
