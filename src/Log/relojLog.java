/*  1:   */ package Log;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.text.SimpleDateFormat;
/*  5:   */ import java.util.Date;
/*  6:   */ import javax.swing.JLabel;
/*  7:   */ 
/*  8:   */ public class relojLog
/*  9:   */   extends Thread
/* 10:   */ {
/* 11:   */   private JLabel label;
/* 12:   */   
/* 13:   */   public relojLog(JLabel label)
/* 14:   */   {
/* 15:17 */     this.label = label;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void run()
/* 19:   */   {
/* 20:   */     for (;;)
/* 21:   */     {
/* 22:21 */       Date fecha = new Date();
/* 23:22 */       SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
/* 24:23 */       this.label.setText(sd.format(fecha));
/* 25:   */       try
/* 26:   */       {
/* 27:26 */         sleep(1000L);
/* 28:   */       }
/* 29:   */       catch (Exception e)
/* 30:   */       {
/* 31:28 */         System.out.println(e);
/* 32:   */       }
/* 33:   */     }
/* 34:   */   }
/* 35:   */ }


/* Location:           E:\Proyect\Java\LEDATEL\dist\LEDATEL.jar
 * Qualified Name:     Log.relojLog
 * JD-Core Version:    0.7.0.1
 */