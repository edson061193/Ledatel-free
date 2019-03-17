/*  1:   */ package Log;
/*  2:   */ 
/*  3:   */ import java.awt.Component;
/*  4:   */ import java.awt.Graphics;
/*  5:   */ import java.awt.Insets;
/*  6:   */ import java.awt.image.BufferedImage;
/*  7:   */ import java.io.PrintStream;
/*  8:   */ import java.net.URL;
/*  9:   */ import javax.imageio.ImageIO;
/* 10:   */ import javax.swing.border.Border;
/* 11:   */ 
/* 12:   */ public class fondoPrincipal
/* 13:   */   implements Border
/* 14:   */ {
/* 15:   */   public BufferedImage back;
/* 16:   */   
/* 17:   */   public fondoPrincipal()
/* 18:   */   {
/* 19:   */     try
/* 20:   */     {
/* 21:20 */       URL imagePath = new URL(getClass().getResource("/Fondos/menu principal.jpg").toString());
/* 22:21 */       this.back = ImageIO.read(imagePath);
/* 23:   */     }
/* 24:   */     catch (Exception e)
/* 25:   */     {
/* 26:23 */       System.out.println(e);
/* 27:   */     }
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
/* 31:   */   {
/* 32:31 */     g.drawImage(this.back, x + (width - this.back.getWidth()) / 2, y + (height - this.back.getHeight()) / 2, null);
/* 33:   */   }
/* 34:   */   
/* 35:   */   public Insets getBorderInsets(Component c)
/* 36:   */   {
/* 37:36 */     return new Insets(0, 0, 0, 0);
/* 38:   */   }
/* 39:   */   
/* 40:   */   public boolean isBorderOpaque()
/* 41:   */   {
/* 42:41 */     return false;
/* 43:   */   }
/* 44:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log.fondoPrincipal
 * JD-Core Version:    0.7.0.1
 */