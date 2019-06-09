package northgods;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.RenderContext;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFrame;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class NorthGods {
    
    static {
	org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger.getRootLogger();
	rootLogger.setLevel(org.apache.log4j.Level.INFO);
	rootLogger.addAppender(new ConsoleAppender(
		    new PatternLayout("%-6r [%p] %c - %m%n")));
    }
 
    public static void main(String[] args) {
	
        String namespace = "http://NorseMythology/Gods#";
        
        Model model = ModelFactory.createDefaultModel();
        
        Property isgod = model.createProperty(namespace+"is God");
        Property is = model.createProperty(namespace+"transformed into");
	Property mates = model.createProperty(namespace+"mates with");
	Property loners = model.createProperty(namespace+"Have No Family");
	Property father = model.createProperty(namespace+"is Father to");
	Property mother = model.createProperty(namespace+"is Mother to");
	
        //Property test = model.createProperty(namespace+"");
	
	
        Resource giants = model.createResource(namespace+"Giants");
	Resource gods = model.createResource(namespace+"Gods");
	Resource ymir= model.createResource(namespace+"Ymir");
	Resource farbauti= model.createResource(namespace+"Farbauti");
	Resource aegir= model.createResource(namespace+"Aegir");
	Resource laufey= model.createResource(namespace+"Laufey");
	Resource ran= model.createResource(namespace+"Ran");
	Resource angrboda= model.createResource(namespace+"Angrboda");
	Resource loki= model.createResource(namespace+"Loki");
	Resource himiglaeva= model.createResource(namespace+"Himiglaeva");
	Resource dufa= model.createResource(namespace+"Dufa");
	Resource blogughadda= model.createResource(namespace+"Blodughadda");
	Resource hefring= model.createResource(namespace+"Hefring");
	Resource udr= model.createResource(namespace+"Udr");
	Resource hronn= model.createResource(namespace+"Hronn");
	Resource bylgja= model.createResource(namespace+"Bylgja");
	Resource drofn= model.createResource(namespace+"Drofn");
	Resource kolga= model.createResource(namespace+"Kolga");
	Resource fenrir= model.createResource(namespace+"Fenrir");
	Resource jormugand= model.createResource(namespace+"Jormugand");
	Resource a_horse= model.createResource(namespace+"A Horse");
	Resource heimdal= model.createResource(namespace+"Heimdal");
	Resource audumbla= model.createResource(namespace+"Audumbla");
	Resource buri= model.createResource(namespace+"Buri");
	Resource burr= model.createResource(namespace+"Burr");
	Resource bestla= model.createResource(namespace+"Bestla");
	Resource vili= model.createResource(namespace+"Vili");
	Resource ve= model.createResource(namespace+"Ve");
	Resource hoenir= model.createResource(namespace+"Hoenir");
	Resource odin= model.createResource(namespace+"Odin");
	Resource jord= model.createResource(namespace+"Jord");
	Resource thor= model.createResource(namespace+"Thor");
	Resource sif= model.createResource(namespace+"Sif");
	Resource ullr= model.createResource(namespace+"Ullr");
	Resource hodr= model.createResource(namespace+"Hodr");
	Resource nanna= model.createResource(namespace+"Nanna");
	Resource forseti= model.createResource(namespace+"Forseti");
	Resource modi= model.createResource(namespace +"Modi");
	Resource thrud= model.createResource(namespace +"Thrud");
	Resource jarnsaxa= model.createResource(namespace +"Jarnsaxa");
	Resource magni= model.createResource(namespace +"Magni");
	Resource njord= model.createResource(namespace +"Njord");
	Resource skadi= model.createResource(namespace +"Skadi");
	Resource freyr= model.createResource(namespace +"Freyr");
	Resource freya= model.createResource(namespace +"Freya");
	Resource gerdr= model.createResource(namespace +"Gerdr");
	Resource odr= model.createResource(namespace +"Odr");
	Resource tyr= model.createResource(namespace +"Tyr");
	Resource minir= model.createResource(namespace +"Minir");
	Resource idunn= model.createResource(namespace +"Idunn");
	Resource sleipnir = model.createResource(namespace +"Sleipnir");
	Resource hel = model.createResource(namespace +"Hel");
        Resource frigg = model.createResource(namespace +"Frigg");
        Resource fjorgynn = model.createResource(namespace +"Fjorgynn");
        Resource baldur = model.createResource(namespace +"Baldur");
        Resource bragi = model.createResource(namespace +"Bragi");
        Resource mimir = model.createResource(namespace +"Mimir");
        Resource idun = model.createResource(namespace +"Idun");
        
        
	model.add(gods,is,giants);
	model.add(gods,is,ymir);
		model.add(ymir,father,angrboda);
		model.add(ymir,father,farbauti);
		model.add(ymir,father,laufey);
		model.add(ymir,father,aegir);
		model.add(ymir,father,ran);
	model.add(gods,is,audumbla);
		model.add(audumbla,mother,buri);
			model.add(buri,father,burr);
	model.add(farbauti,mates,laufey);
		model.add(farbauti,father,loki);
		model.add(laufey,mother,loki);
	model.add(loki,mates,angrboda);
		model.add(loki,father,fenrir);
		model.add(loki,father,jormugand);
		model.add(loki,father,hel);
		model.add(angrboda,mother,fenrir);
		model.add(angrboda,mother,jormugand);
		model.add(angrboda,mother,hel);
	model.add(loki,mates,a_horse);
		model.add(loki,father,sleipnir);
		model.add(a_horse,mother,sleipnir);
	model.add(aegir,mates,ran);
		model.add(aegir,father,himiglaeva);
                model.add(aegir,father,dufa);
                model.add(aegir,father,blogughadda);
                model.add(aegir,father,hefring);
                model.add(aegir,father,udr);
                model.add(aegir,father,hronn);
                model.add(aegir,father,bylgja);
                model.add(aegir,father,drofn);
                model.add(aegir,father,kolga);
                model.add(ran,mother,himiglaeva);
                model.add(ran,mother,dufa);
                model.add(ran,mother,blogughadda);
                model.add(ran,mother,hefring);
                model.add(ran,mother,udr);
                model.add(ran,mother,hronn);
                model.add(ran,mother,bylgja);
                model.add(ran,mother,drofn);
                model.add(ran,mother,kolga);
                model.add(himiglaeva,mother,heimdal);
                model.add(dufa,mother,heimdal);
                model.add(blogughadda,mother,heimdal);
                model.add(hefring,mother,heimdal);
                model.add(udr,mother,heimdal);
                model.add(hronn,mother,heimdal);
                model.add(bylgja,mother,heimdal);
                model.add(drofn,mother,heimdal);
                model.add(kolga,mother,heimdal);
        model.add(burr,mates,bestla);
            model.add(burr,father,hoenir);
            model.add(burr,father,odin);
            model.add(burr,father,vili);
            model.add(burr,father,ve);
            model.add(bestla,mother,hoenir);
            model.add(bestla,mother,odin);
            model.add(bestla,mother,vili);
            model.add(bestla,mother,ve);
        model.add(fjorgynn,father,frigg);
        model.add(odin,mates,frigg);
            model.add(odin,father,baldur);
            model.add(frigg,mother,baldur);
        model.add(odin,mates,jord);
            model.add(jord,mother,thor);
            model.add(odin,father,thor);
                model.add(thor,mates,sif);
                    model.add(thor,father,thrud);
                    model.add(thor,father,modi);
                    model.add(sif,mother,thrud);
                    model.add(sif,mother,modi);
        model.add(odin,mates,sif);
            model.add(odin,father,ullr);
            model.add(sif,mother,ullr);
            model.add(baldur,mates,nanna);
                model.add(baldur,father,forseti);
                model.add(nanna,mother,forseti);
        model.add(odin,father,hodr);
        model.add(odin,father,bragi);
        model.add(thor,mates,jarnsaxa);
            model.add(thor,father,magni);
            model.add(jarnsaxa,mother,magni);
        model.add(njord,mates,skadi);
            model.add(njord,father,freya);
            model.add(skadi,mother,freya);
            model.add(njord,father,freyr);
            model.add(skadi,mother,freyr);
        model.add(freyr,mates,gerdr);
        model.add(odr,mates,freya);
        model.add(gods,isgod,tyr);
        model.add(gods,isgod,mimir);
        model.add(gods,isgod,idun);
        model.add(hel,mother,njord);       
                
                
                
                    
        try{
	    PrintWriter p = new PrintWriter(new File("northgods.rdf"));
	    model.write(p);
	    p.close();
	}
	catch (IOException e){

	}
                    
	Graph<RDFNode, Statement> g = new JenaJungGraph(model);
	
	
	Layout<RDFNode, Statement> layout = new FRLayout(g);
	layout.setSize(new Dimension(800, 600));
	
	BasicVisualizationServer<RDFNode, Statement> viz =
		new BasicVisualizationServer<>(layout);
	RenderContext context = viz.getRenderContext();
	context.setEdgeLabelTransformer(Transformers.EDGE);
	context.setVertexLabelTransformer(Transformers.NODE);

	viz.setPreferredSize(new Dimension(1000, 800));
	JFrame frame2= new JFrame("Search Your Favourite God");  // BONUS (single_line) ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	JFrame frame = new JFrame("Norse Gods");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      //  frame.getContentPane().add(viz);
        JPanel mapanel= new JPanel();
        JPanel panel2 = new JPanel();
        
        FlowLayout flow = new FlowLayout();
        
        frame.add(mapanel);
        panel2.setLayout(flow);
          // BONUS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        frame2.setVisible(false);
        frame2.setSize(1200,400);
        JLabel imgboy = new JLabel(" <--- god");
        JButton pew = new JButton("Info");
        JButton gob = new JButton(" Go back");
        JTextField myText = new JTextField("",5);
        frame2.add(panel2);
        panel2.add(gob);
        panel2.add(myText);
        panel2.add(imgboy);
        JLabel family = new JLabel("<---family");
        panel2.add(family);
        
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setResizable(false);
        mapanel.add(viz);
        mapanel.add(pew);
     //  panel2.add(gob);
      //  frame.add(panel1);
          // BONUS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	frame.pack();
	frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Hashtable<String,RDFNode> nodeTable = new Hashtable<String,RDFNode>();
            nodeTable.put("ymir",ymir);
            nodeTable.put("9_mothers",udr);
            nodeTable.put("farbauti",farbauti);
            nodeTable.put("laufey",laufey);
            nodeTable.put("aegir",aegir);
            nodeTable.put("ran",ran);
            nodeTable.put("audumbla",audumbla);
            nodeTable.put("buri",buri);
            nodeTable.put("angrboda",angrboda);
            nodeTable.put("loki",loki);
            nodeTable.put("horse",a_horse);
            nodeTable.put("bestla",bestla);
            nodeTable.put("burr",burr);
            nodeTable.put("buri",buri);
            nodeTable.put("fjorgynn",fjorgynn);
            nodeTable.put("frigg",frigg);
            nodeTable.put("ve",ve);
            nodeTable.put("vili",vili);
            nodeTable.put("odin",odin);
            nodeTable.put("hoenir",odin);
            nodeTable.put("heimdal",heimdal);
            nodeTable.put("jord",jord);
            nodeTable.put("sleipnir",sleipnir);
            nodeTable.put("hel",hel);
            nodeTable.put("jormungand",jormugand);
            nodeTable.put("fenrir",fenrir);
            nodeTable.put("skadi",skadi);
            nodeTable.put("njord",njord);
            nodeTable.put("idun",idun);
            nodeTable.put("jarnsaxa",jarnsaxa);
            nodeTable.put("thor",thor);
            nodeTable.put("sif",sif);
            nodeTable.put("hodr",hodr);
            nodeTable.put("bragi",bragi);
            nodeTable.put("baldur",baldur);
            nodeTable.put("nanna",nanna);
            nodeTable.put("gerdr",gerdr);
            nodeTable.put("freyr",freyr);
            nodeTable.put("freya",freya);
            nodeTable.put("odr",odr);
            nodeTable.put("magni",magni);
            nodeTable.put("thrud",thrud);
            nodeTable.put("modi",modi);
            nodeTable.put("ullr",ullr);
            nodeTable.put("tyr",tyr);
            nodeTable.put("mimir",mimir);
            nodeTable.put("forseti",forseti);

            
        // BONUS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
         Hashtable<String,ImageIcon> ohmaikot = new Hashtable<String,ImageIcon>();
              ohmaikot.put("ymir", new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/ymir.png"));
               //  ImageIcon imageNot 
              ohmaikot.put("notfound",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/notFound.png"));
               //  ImageIcon mothersIcon 
              ohmaikot.put("9_mothers",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/9_mothers.png"));
               //  ImageIcon aegirIcon 
              ohmaikot.put("aegir",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/aegir.png"));
                // ImageIcon angrbodaIcon 
              ohmaikot.put("angrboda",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/angrboda.png"));
               //  ImageIcon audumblaIcon 
              ohmaikot.put("audumbla",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/audubmbla.png"));
               //  ImageIcon baldurIcon
              ohmaikot.put("baldur",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/baldur.png"));
              //  ImageIcon bestlaIcon
              ohmaikot.put("bestla",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/bestla.png"));
               //  ImageIcon bragiIcon 
              ohmaikot.put("bragi",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/bragi.png"));
             //    ImageIcon buriIcon
              ohmaikot.put("buri",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/buri.png"));
               //  ImageIcon burrIcon 
              ohmaikot.put("burr",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/burr.png"));
             //    ImageIcon farbautiIcon 
              ohmaikot.put("farbauti",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/farbauti.png"));
            //     ImageIcon fenrirIcon 
              ohmaikot.put("fenrir",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/fenrir.png"));
          //       ImageIcon fjorgynnIcon
              ohmaikot.put("fjorgynn",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/fjorgynn.png"));
           //      ImageIcon forsetiIcon
              ohmaikot.put("forseti",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/forseti.png"));
           //      ImageIcon freyaIcon
              ohmaikot.put("freya",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/freya.png"));
         //        ImageIcon friggIcon
              ohmaikot.put("frigg",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/frigg.png"));
           //      ImageIcon gerdrIcon 
              ohmaikot.put("gerdr",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/gerdr.png"));
          //       ImageIcon heimdalIcon 
              ohmaikot.put("heimdal",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/heimdal.png"));
           //      ImageIcon helIcon 
              ohmaikot.put("hel",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/hel.png"));
           //      ImageIcon hodrIcon
              ohmaikot.put("hodr",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/hodr.png"));
          //       ImageIcon hoenirIcon
              ohmaikot.put("hoenir",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/hoenir.png"));
          //       ImageIcon horseIcon
              ohmaikot.put("horse",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/horse.png"));
          //       ImageIcon idunIcon
              ohmaikot.put("idun",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/idun.png"));
          //       ImageIcon jarnsaxaIcon
              ohmaikot.put("jarnsaxa",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/jarnsaxa.png"));
          //       ImageIcon jordIcon 
              ohmaikot.put("jord",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/jord.png"));
          //       ImageIcon jormurngandIcon
              ohmaikot.put("jormungand",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/jormungand.png"));
          //       ImageIcon laufeyIcon
              ohmaikot.put("laufey",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/laufey.png"));
          //       ImageIcon lokiIcon
              ohmaikot.put("loki",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/loki.png"));
           //      ImageIcon magniIcon
              ohmaikot.put("magni",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/magni.png"));
          //       ImageIcon mimirIcon
              ohmaikot.put("mimir",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/mimir.png"));
          //       ImageIcon modiIcon 
              ohmaikot.put("modi",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/modi.png"));
          //       ImageIcon nannaIcon
              ohmaikot.put("nanna",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/nanna.png"));
         //        ImageIcon njordIcon
              ohmaikot.put("njord",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/njord.png"));
         //        ImageIcon odinIcon
              ohmaikot.put("odin",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/odin.png"));
         //        ImageIcon odrIcon 
              ohmaikot.put("odr",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/odr.png"));
         //        ImageIcon ranIcon 
              ohmaikot.put("ran",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/ran.png"));
         //        ImageIcon sifIcon
              ohmaikot.put("sif",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/sif.png"));
         //        ImageIcon skadiIcon 
              ohmaikot.put("skadi",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/skadi.png"));
         //        ImageIcon sleipnirIcon 
              ohmaikot.put("sleipnir",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/sleipnir.png"));
        //         ImageIcon thorIcon)
              ohmaikot.put("thor",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/thor.png"));
         //        ImageIcon thrudIcon
              ohmaikot.put("thrud",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/thrud.png"));
         //        ImageIcon tyrIcon
              ohmaikot.put("tyr",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/tyr.png"));
         //        ImageIcon ullrIcon
              ohmaikot.put("ullr",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/ullr.png"));
         //        ImageIcon veIcon 
              ohmaikot.put("vel",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/ve.png"));
         //        ImageIcon viliIcon
              ohmaikot.put("vili",new ImageIcon("C:/Users/George/Documents/NetBeansProjects/wallace/vili.png"));
        
         // BONUS ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~       
              
        pew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(true);
                
            }
        });
       
        gob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
            }
        }); 
        
        myText.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("Inserting");
                String kek = myText.getText();
                if(nodeTable.containsKey(kek)){ 
                 try {
                       countChars();
                    } catch (IOException ex) {
                        Logger.getLogger(NorthGods.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                     imgboy.setIcon(ohmaikot.get("notfound"));
                    }
                
            }
             
            

            @Override
            public void removeUpdate(DocumentEvent e) {
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
                
            }
            private void countChars() throws IOException{
                
                String familyText;
                String pew = myText.getText();
                Collection<RDFNode> familyNodes = g.getNeighbors(nodeTable.get(pew));
                
               
                    imgboy.setIcon(ohmaikot.get(pew));      
                    familyText=familyNodes.toString();
                    String tempstr = familyText.replaceAll("http://NorseMythology/Gods#","");
                   // String tempstr1 = tempstr.replace("[","");
                   // String tempstr2 = tempstr1.replace("]","");
                    family.setText(tempstr);
                
                
               // }
            }
        
        });
    }
}
