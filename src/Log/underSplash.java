/*  1:   */ package Log;
/*  2:   */ 
/*  3:   */ import com.sun.awt.AWTUtilities;

/*  4:   */ import javax.swing.JFrame;
/*  5:   */ 
/*  6:   */ public class underSplash
/*  7:   */ {
/*  8:   */   public void transparencia(JFrame frme)
/*  9:   */   {
/* 10:17 */     frme.setUndecorated(true);
/* 11:18 */     AWTUtilities.setWindowOpaque(frme, false);
/* 12:   */   }
/* 13:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log.underSplash
 * JD-Core Version:    0.7.0.1
 */