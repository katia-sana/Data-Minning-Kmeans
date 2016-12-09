

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
/*
1. calcule distance entre deux individus
2. calcule du centre de gravité (individu avc moyenne de chaque attribut)
3. variance des individus du dataset
*/

class DataSet
{
    public int idf;
    public double[] tuple;
    public String absprs;
    
    public DataSet(int n)
    {
        tuple = new double[n];
    }
}

class Kmeans
{
    public ArrayList C1 = new ArrayList();
    public ArrayList C2 = new ArrayList();
    int ind1,ind2;
    public DataSet G1,G2;
    ArrayList L;
    
    
    public Kmeans(ArrayList L)
    {
        this.L = L;
        ind1 = ind2 = (int) (Math.random() * (L.size()-1));
        while(ind1==ind2) ind2 = (int) (Math.random() * (L.size()-1));
        C1.add(ind1); C2.add(ind2);
        G1 = (DataSet)L.get(ind1);
        G2 = (DataSet)L.get(ind2);
    }
    
    public void Calculer()
    {
      data_mining o = new data_mining();
        for(int i=0;i<(L.size()-1);i++)
        {
            if(i!=ind1 && i!=ind2)
            {
                double d1 = o.Distance(G1, (DataSet)L.get(i));
                double d2 = o.Distance(G2, (DataSet)L.get(i));
                
                if(d1<=d2)
                {
                    C1.add(i);
                    int[] temp = new int[C1.size()];
                    for(int s=0;s<C1.size();s++) temp[s] = (Integer)C1.get(s);
                    G1 = o.CGravite(C1.size(), temp);
                 
                }
                if(d1>d2)
                {
                    C2.add(i);
                    int[] temp = new int[C2.size()];
                    for(int s=0;s<C2.size();s++) temp[s] = (Integer)C2.get(s);
                    G2 = o.CGravite(C2.size(), temp);
                }
                
            }
        }
    }
    
    
}

public class data_mining extends javax.swing.JFrame {

    /** Creates new data_mining */
    public data_mining() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("DATASET:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "HeartStat" }));

        jButton1.setText("Load");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("STATUS:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Distance");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Centre");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2)
                        .addGap(83, 83, 83)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton2)
                .addGap(35, 35, 35)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private ArrayList L;
    
    double  arrondir(Double x)
    {
        String s = x.toString();
        String c = "";
        int i = 0; int ind = 0;
        while(i<s.length() && ind<3)
        {
            if(ind==0)
            {
                if(s.charAt(i)=='.') ind++;
                c+=s.charAt(i);
            }
            else {ind++ ;c+=s.charAt(i);}
            i++;
        }
        return Double.valueOf(c);
    }
    
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    L = new ArrayList(); int idf = 1;
        BufferedReader LecteurBufferise = null;
        String Chemin = jComboBox1.getSelectedItem().toString()+".txt";
        String ligneDonnee;
        boolean eof = false;
        try {

        //Ouverture du Fichier
        LecteurBufferise = new BufferedReader(new FileReader(Chemin));
        while (eof != true) 
        {
          //Lecture de la ligne
          ligneDonnee = LecteurBufferise.readLine();
          if (ligneDonnee != null) {
          //System.out.println(ligneDonnee);
          //creation des Objets Heart_stat
          String[] Tab = ligneDonnee.split(","); //Tuple=ligne
          DataSet DS = new DataSet(Tab.length-1);
          //Attributs Créations
          DS.idf = idf++;
          int s;
          for(s=0;s<Tab.length-1;s++) DS.tuple[s] = Double.valueOf(Tab[s]);
          DS.absprs = Tab[s];
          L.add(DS); //Ajout a la liste
          
        }
        else {
          eof = true;
        }
      }
    }
    catch (FileNotFoundException ex) {
      jTextArea1.setText("Fichier Non Trouvé !!");
    }
    catch (IOException ex) {
      jTextArea1.setText("Erreur lecture ligne fichier !!");
    }
    finally {
      try {
        LecteurBufferise.close();
      }
      catch (IOException ex1) {
        jTextArea1.setText("Erreur fermeture fichier !!");
      }
    }
        jTextArea1.setText(null);
        for(int i=0;i<L.size();i++)     //Affichage des tuples
        {
            DataSet DS = (DataSet) L.get(i);
            jTextArea1.append(DS.idf+"  ");
            int s;
            for(s=0;s<DS.tuple.length;s++) jTextArea1.append(DS.tuple[s]+"  ");
            jTextArea1.append(DS.absprs+"\n");
        }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    if(jRadioButton1.isSelected())
    {
        int tuple1 = (int) (Math.random() * L.size());
        int tuple2 = (int) (Math.random() * L.size());
        double dist;
        dist=Distance((DataSet)L.get(tuple1),(DataSet)L.get(tuple2));
        dist=Math.round(dist+0.5);
        jTextArea2.append("la distance: \n");
        jTextArea2.append("Tuple1 N°: "+tuple1+"\n");
        jTextArea2.append("Tuple2 N°: "+tuple2+"\n");
        jTextArea2.append(String.valueOf(dist)+"\n\n");
        System.out.println(dist);
    }
    if(jRadioButton2.isSelected())
    {
        jTextArea2.append("\n\nCentre de Gravité:\n");
    
    int[] elmts= new int[L.size()];
    int j=0;
   
     int nbre_elt = 0;
     while(nbre_elt<3) nbre_elt=(int) (Math.random() * L.size()/10);
     jTextArea2.append("Le nombre d'elements de Cluster:  "+nbre_elt+"\n");
     jTextArea2.append("Les Tuples de Cluster:\n");

    //affectation des elements aléatoirement sans repetitions
    for(int i=0;i<nbre_elt;i++)
    {
        elmts[i] = 0; boolean trouve = true;
        while(elmts[i]<5 || trouve) 
        {
            trouve = false;
            elmts[i]=(int) (Math.random() * (L.size()-1));
            for(int k=0;k<i;k++)if(elmts[i]==elmts[k])trouve = true;
        }
        jTextArea2.append("* "+elmts[i]+"\n");
    }
    
    DataSet centre= CGravite(nbre_elt,elmts);
    
    //l'affichage du Centre de gravité;
    jTextArea2.append("\n\nLe Centre de Gravité :\n");
    for(int s=0;s<centre.tuple.length;s++) jTextArea2.append(arrondir(centre.tuple[s])+"  ");
    }
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    jTextArea1.setText(null);
    jTextArea2.setText(null);
}//GEN-LAST:event_jButton3ActionPerformed

private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    jRadioButton1.setSelected(true);
    jRadioButton2.setSelected(false);
}//GEN-LAST:event_jRadioButton1ActionPerformed

private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

    jRadioButton1.setSelected(false);
    jRadioButton2.setSelected(true);
}//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(data_mining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_mining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_mining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_mining.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new data_mining().setVisible(true);
            }
        });
    }
    
    public double Distance(DataSet  DS1, DataSet  DS2)
    {
        
        double dist=0;
        double somme=0;
        for(int s=0;s<DS1.tuple.length;s++) somme += Math.pow(DS1.tuple[s]-DS2.tuple[s],2);
        dist=Math.sqrt(somme);
        return dist;
    }

   public DataSet CGravite(int  nbre, int[] elmts)
    {
       double somme,g;
       int j;
       DataSet G = new DataSet(((DataSet)L.get(0)).tuple.length);
       
       //Calcule de CGravite
       G.idf = 0;
       for(int s=0;s<G.tuple.length;s++) G.tuple[s] = 0;
       
       for(int i=0;i<nbre;i++) 
       {
           for(int s=0;s<G.tuple.length;s++) G.tuple[s] += ((DataSet)L.get(elmts[i])).tuple[s];
       }
       
       for(int s=0;s<G.tuple.length;s++) G.tuple[s] /= nbre;
               
       return G;
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
