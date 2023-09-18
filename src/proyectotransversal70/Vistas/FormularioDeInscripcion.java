
package proyectotransversal70.Vistas;

import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import proyectotransversal70.AccesoADatos.AlumnoData;
import proyectotransversal70.AccesoADatos.Conexion;
import proyectotransversal70.AccesoADatos.InscripcionData;
import proyectotransversal70.entidades.Alumno;
import proyectotransversal70.entidades.Inscripcion;
import proyectotransversal70.entidades.Materia;


public class FormularioDeInscripcion extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modeloTabla=new DefaultTableModel();
    private ButtonGroup buttonGroup = new ButtonGroup();// un grupo de botones de radio solo uno de ellos puede estar seleccionado a la vez.

    
    public FormularioDeInscripcion() {
        initComponents();
         cargarComboBox();
         armarCabecera();
         buttonGroup.add(jRmateriasInscriptas);
         buttonGroup.add(jRMatNoInscriptas);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        ListaAlumnosComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jRmateriasInscriptas = new javax.swing.JRadioButton();
        jRMatNoInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jBInscribir = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jBAnularInscripcion = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 14)); // NOI18N
        jLabel1.setText("Formulario de Inscripción");

        jLabel2.setText("Seleccione un alumno:");

        ListaAlumnosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaAlumnosComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Leelawadee UI Semilight", 1, 13)); // NOI18N
        jLabel3.setText("Listado de Materias");

        jRmateriasInscriptas.setText("Materias Inscriptas");
        jRmateriasInscriptas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRmateriasInscriptasItemStateChanged(evt);
            }
        });
        jRmateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRmateriasInscriptasActionPerformed(evt);
            }
        });

        jRMatNoInscriptas.setText("Materias no Inscriptas");
        jRMatNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRMatNoInscriptasActionPerformed(evt);
            }
        });

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTabla);

        jBInscribir.setText("Inscribir");

        jBsalir.setText("Salir");

        jBAnularInscripcion.setText("Anular Inscripcion");
        jBAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAnularInscripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBInscribir)
                                .addGap(54, 54, 54)
                                .addComponent(jBAnularInscripcion)
                                .addGap(35, 35, 35)
                                .addComponent(jBsalir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(19, 19, 19)
                                .addComponent(ListaAlumnosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(320, 320, 320)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(108, 108, 108)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jRmateriasInscriptas)
                                        .addGap(37, 37, 37)
                                        .addComponent(jRMatNoInscriptas)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ListaAlumnosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRmateriasInscriptas)
                    .addComponent(jRMatNoInscriptas))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBInscribir)
                    .addComponent(jBsalir)
                    .addComponent(jBAnularInscripcion))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListaAlumnosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaAlumnosComboBoxActionPerformed
        Object selectedItem = ListaAlumnosComboBox.getSelectedItem();
        if (selectedItem instanceof Alumno) {
            Alumno alumnoSeleccionado = (Alumno) selectedItem;
            limpiarTabla();
    }//GEN-LAST:event_ListaAlumnosComboBoxActionPerformed
    }
    private void jRmateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRmateriasInscriptasActionPerformed

        //  jRMatNoInscriptas.setEnabled(false); // Inhabilita el otro botón de radio

            InscripcionData iData = new InscripcionData();
            Alumno alumnoSeleccionado = (Alumno) ListaAlumnosComboBox.getSelectedItem();
            if (alumnoSeleccionado != null) {
                ArrayList<Inscripcion> inscripciones = new ArrayList<>();

            }

            limpiarTabla();
            for (Materia materia: iData.obtenerMateriasCursadas(alumnoSeleccionado.getIdAlumno())) {
                cargarDatos(materia);

            }
           
    }//GEN-LAST:event_jRmateriasInscriptasActionPerformed

    private void jRMatNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRMatNoInscriptasActionPerformed
      
            InscripcionData iData = new InscripcionData();
            Alumno alumnoSeleccionado = (Alumno) ListaAlumnosComboBox.getSelectedItem();
            if (alumnoSeleccionado != null) {
                ArrayList<Inscripcion> inscripciones = new ArrayList<>();

            }
              limpiarTabla();
            for (Materia materia: iData.obtenerMateriaNOCursadas(alumnoSeleccionado.getIdAlumno())) {
                cargarDatos(materia);
            }
    }//GEN-LAST:event_jRMatNoInscriptasActionPerformed

    private void jBAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnularInscripcionActionPerformed
        InscripcionData iData=new InscripcionData();
        
        int filaSeleccionada=jTabla.getSelectedRow();
        int idMateria=(Integer)jTabla.getValueAt(filaSeleccionada, 0);
        
        
          Alumno alumnoSeleccionado = (Alumno) ListaAlumnosComboBox.getSelectedItem();
         
          int idAlumno=(Integer)alumnoSeleccionado.getIdAlumno();//obtengo id alumno
           
        
         iData.borrarInscripcionMateriaAlumno(idAlumno, idMateria);
       
        
        
    }//GEN-LAST:event_jBAnularInscripcionActionPerformed

    private void jRmateriasInscriptasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRmateriasInscriptasItemStateChanged
       
    }//GEN-LAST:event_jRmateriasInscriptasItemStateChanged

    private void jTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablaMouseClicked
        int filaSeleccionada=jTabla.getSelectedRow();
        if(filaSeleccionada!=-1){//si hay una fila seleccionada va a ser diferente a 1
    /*oBTENGO ID MATERIA*/int idMateria=(Integer)jTabla.getValueAt(filaSeleccionada, 0);//getValue extrae el dato de la fila selec y lo extrae un Objeto por eso se debe castear
        }
          
            InscripcionData iData = new InscripcionData();
            Alumno alumnoSeleccionado = (Alumno) ListaAlumnosComboBox.getSelectedItem();
            alumnoSeleccionado.getIdAlumno();//obtengo id alumno
            
            
        
    }//GEN-LAST:event_jTablaMouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> ListaAlumnosComboBox;
    private javax.swing.JButton jBAnularInscripcion;
    private javax.swing.JButton jBInscribir;
    private javax.swing.JButton jBsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRMatNoInscriptas;
    private javax.swing.JRadioButton jRmateriasInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTabla;
    // End of variables declaration//GEN-END:variables
   
    
    private void cargarComboBox() {

        AlumnoData alu = new AlumnoData();

        ArrayList<Alumno> listaAlumnos = (ArrayList<Alumno>) alu.listarAlumnos();// no me dejo armar primero el array y agregar luego el metodo...me lo sugirio asi

        ListaAlumnosComboBox.removeAllItems();

        for (Alumno alumno : listaAlumnos) {
            ListaAlumnosComboBox.addItem(alumno);
        }

    }

    private void armarCabecera() {
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Año");
        jTabla.setModel(modeloTabla);
    }

    private void cargarDatos(Materia materia) {// a partir delbuton rsdio seleccionado mostrara estos datos
        modeloTabla.addRow(new Object[]{materia.getIdMateria(),
            materia.getNombre(), materia.getAnioMateria()
        });
    }

    private void limpiarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) jTabla.getModel();
        modeloTabla.setRowCount(0);
    }

}//----fin clase



