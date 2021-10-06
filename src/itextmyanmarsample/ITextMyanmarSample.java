
package itextmyanmarsample;

/**
 *
 * @author suntun
 */
import java.io.File;
import java.io.FileOutputStream;

import com.suntun.itextmyanmar.MyanmarLigaturizer;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author suntun
 */
public class ITextMyanmarSample {

    public static void main(String[] args) {
        Document document = new Document();
        //String localFontPath = ITextMyanmarSample.class.getClassLoader().getResource("pds253r.ttf").getPath();
        String localFontPath = "pds253r.ttf";
        String para1 = "1. ဘယ်ကိုဗစ်ကာကွယ်ဆေးက ပိုအစွမ်းထက်သလဲ၊ တရုတ်နိုင်ငံထုတ် ဆေးတွေ အပါအဝင် မြန်မာနိုင်ငံမှာ ရနိုင်တဲ့ ကာကွယ်ဆေးတွေက" +
                       "အာနိသင်ရှိရဲ့လား၊ အနောက်နိုင်ငံထုတ် ဆေးတွေလောက် ရောဂါကူးစက်မှုကို ကာကွယ်နိုင်ပါ့မလား ဆိုတာတွေနဲ့ ပတ်သက်လို့ မြန်မာ " +
                        "ပြည်သူအများကြားမှာ မေးခွန်းထုတ် နေကြပါတယ်။ ဒီတော့ ကာကွယ်ဆေး ထိုးသင့် မထိုးသင့် ဝေခွဲမရ တာတွေ ရှိလာပါတယ်။";
       String para2 = "ချဲ့ ကဏ္ဍ သဏ္ဌာန် ဥက္ကဋ္ဌ ဝဏ္ဏ ဝဍ္ဎ ကမ္ဘာကြီး";
       String para3 ="သီဟိုဠ်မှ ဉာဏ်ကြီးရှင်သည် အာယုဝဍ္ဎနဆေးညွှန်းစာကို ဇလွန်ဈေးဘေး ဗာဒံပင်ထက် အဓိဋ္ဌာန်လျက် ဂဃနဏဖတ်ခဲ့သည်";
        try {
        	File file = new File("UnicodeExamplePDF.pdf");
//        	if (!file.exists()) {
//        		file.createNewFile();
//        	}
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            MyanmarLigaturizer d = new MyanmarLigaturizer();
            String strProcess = d.process("မင်္ဂလာပါ ရွှင်လန်းချမ်းမြေ့ပါစေ");
            BaseFont bfComic = BaseFont.createFont(localFontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            document.add(new Paragraph("Hello"));
            document.add(new Paragraph(strProcess, new Font(bfComic, 22)));
            document.add(new Paragraph("\n"));
            //document.add(new Paragraph(d.process("ချဲ့ ကဏ္ဍ သဏ္ဌာန် ဥက္ကဋ္ဌ ဝဏ္ဏ ဝုဎ္ဍိ "), new Font(bfComic, 12))) ;
            document.add(new Paragraph(d.process(para1), new Font(bfComic, 12))) ;
            document.add(new Paragraph(d.process(para2), new Font(bfComic, 12))) ;
            document.add(new Paragraph(d.process(para3), new Font(bfComic, 12))) ;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        document.close();
    }  
}
