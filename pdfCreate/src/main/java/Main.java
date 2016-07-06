
import java.io.FileOutputStream;
import java.util.Map;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class Main {

    public static void main(String[] args) throws Exception {

        String fileName = "d:\\2.pdf"; //
        PdfReader reader = new PdfReader(fileName);

        PdfStamper ps = new PdfStamper(reader, new FileOutputStream("d:\\3.pdf"));

        AcroFields afs = ps.getAcroFields();

        Map<String, Item> fieldMap = afs.getFields();

        afs.setField("name", "你好");
        afs.setField("password", "中国123");

        Image gif = Image.getInstance("d:\\1.png");
        gif.setDpi(100, 100);
        gif.setBorderWidth(200);
        gif.scaleAbsolute(80, 100);
        gif.setAbsolutePosition(400, 0);
        PdfContentByte over = ps.getOverContent(2);
        over.addImage(gif);

        ps.setFormFlattening(true); // 这句不能少
        ps.close();
        reader.close();

    }

}
