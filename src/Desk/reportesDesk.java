/*  1:   */ package Desk;
/*  2:   */ 
/*  3:   */ import java.awt.Container;
/*  4:   */ import javax.swing.GroupLayout;
/*  5:   */ import javax.swing.GroupLayout.Alignment;
/*  6:   */ import javax.swing.GroupLayout.ParallelGroup;
/*  7:   */ import javax.swing.JInternalFrame;
/*  8:   */ 
/*  9:   */ public class reportesDesk
/* 10:   */   extends JInternalFrame
/* 11:   */ {
/* 12:14 */   private static reportesDesk fromReporte = null;
/* 13:   */   
/* 14:   */   public static reportesDesk getForm()
/* 15:   */   {
/* 16:17 */     if (fromReporte == null) {
/* 17:18 */       fromReporte = new reportesDesk();
/* 18:   */     }
/* 19:20 */     return fromReporte;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public reportesDesk()
/* 23:   */   {
/* 24:26 */     initComponents();
/* 25:   */   }
/* 26:   */   
/* 27:   */   private void initComponents()
/* 28:   */   {
/* 29:38 */     setClosable(true);
/* 30:39 */     setIconifiable(true);
/* 31:40 */     setTitle("Lista de Reportes");
/* 32:   */     
/* 33:42 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 34:43 */     getContentPane().setLayout(layout);
/* 35:44 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 578, 32767));
/* 36:   */     
/* 37:   */ 
/* 38:   */ 
/* 39:48 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 500, 32767));
/* 40:   */     
/* 41:   */ 
/* 42:   */ 
/* 43:   */ 
/* 44:53 */     pack();
/* 45:   */   }
/* 46:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Desk.reportesDesk
 * JD-Core Version:    0.7.0.1
 */