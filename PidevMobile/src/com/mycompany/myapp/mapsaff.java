/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.InteractionDialog;
import com.codename1.components.ToastBar;
import com.codename1.googlemaps.MapContainer;
import com.codename1.googlemaps.MapLayout;
import com.codename1.maps.Coord;
import com.codename1.maps.*;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.SideMenuBar;
import com.codename1.ui.TextField;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompagny.Service.RdvService;
import com.mycompany.Entite.rdv;
import java.io.IOException;

/**
 *
 * @author tanga
 */
public class mapsaff {
 rdv loc = new rdv();
     RdvService ser = new RdvService();
    private static final String HTML_API_KEY = "AIzaSyC1fQeKkLDu7XvdEsrU50XOCyf8MACyZbo";
    
    Form hi = new Form();
    //  Form mapDemo = new Form("Maps", new LayeredLayout());

    
   
        public mapsaff(String longi , String lalti)
        {     final MapContainer cnt = new MapContainer(HTML_API_KEY);

        final boolean[] init = {false};

        Style s = new Style();
        s.setFgColor(0xff0000);
        s.setBgTransparency(0);
        

        FontImage image = FontImage.createMaterial(FontImage.MATERIAL_PLACE, s, Display.getInstance().convertToPixels(1));
        Coord coord = new Coord(Double.parseDouble(lalti), Double.parseDouble(longi));

        cnt.addMapListener((e1, e2, e3) -> {
            if (!init[0]){
                cnt.setCameraPosition(coord);
              //  cnt.addMarker(EncodedImage.createFromImage(image,false), coord, "Text", "Text", null);
                init[0] = true;
            }
        });

           hi.setLayout(new BorderLayout());
     
    
     

     
 cnt.addMarker(
                        EncodedImage.createFromImage(image, false),
                        new Coord(Double.parseDouble(lalti), Double.parseDouble(longi)),
                        "",
                        "",
                        e3->{   
                                ToastBar.showMessage("ariana", FontImage.MATERIAL_PLACE);
                                
                        }
                        
                        
                );
        Container root = LayeredLayout.encloseIn(
                BorderLayout.center(cnt)
               
        );
 //cnt.setCameraPosition(new Coord(36.862499, 10.195556));
       // hi.add(BorderLayout.CENTER, root);
    //   hi.add(cnt);
    hi.add(BorderLayout.CENTER, root);
       // hi.show();

    }

   
    public Form getF() {
        return hi;
    }

    public void setF(Form f) {
        this.hi = f;
    }
}
