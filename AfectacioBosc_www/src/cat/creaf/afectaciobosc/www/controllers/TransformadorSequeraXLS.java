/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import Excel.TransformadorXLS;
import MSIPANBasicObj.ObjecteSIPAN;
import cat.creaf.afectaciobosc.model.Sequera;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class TransformadorSequeraXLS
    implements TransformadorXLS
{

    private SimpleDateFormat spdf;
    
    public TransformadorSequeraXLS()
    {
        spdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void transformar(Object obj, HSSFRow row)
    {
        if(obj instanceof ObjecteSIPAN)
        {
            Sequera sequera = (Sequera)obj;
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(sequera.getIdString());
            cell = row.createCell(1);
            cell.setCellValue(sequera.getComarca() == null ? "" : sequera.getComarca().toString());
            cell = row.createCell(2);
            cell.setCellValue(sequera.getData() == null ? "" : spdf.format(sequera.getData()));
            cell = row.createCell(3);
            String especie1 = "";
            String grauAfect = "";
            if(sequera.getAfectacionsEstimades().size()>0 &&
                    sequera.getAfectacionsEstimades().get(0).getEspecie()!=null){
                especie1 = sequera.getAfectacionsEstimades().get(0).getEspecie().toString();
                grauAfect = sequera.getAfectacionsEstimades().get(0).getAfectacio();
            }
            cell.setCellValue(especie1);
            cell = row.createCell(4);
            cell.setCellValue(grauAfect);
            cell = row.createCell(5);
            cell.setCellValue(sequera.getCodi());
            cell = row.createCell(6);
            String area = "";
            if(sequera.getAreaAfectada()!=null){
                DecimalFormat df = new DecimalFormat("#0.00");
                area = df.format(sequera.getAreaAfectada().getArea()/10000);
            }
            cell.setCellValue(area);
            cell = row.createCell(7);
            cell.setCellValue(sequera.getCodiAgent1() == null ? "" : sequera.getCodiAgent1());
            cell = row.createCell(8);
            cell.setCellValue(sequera.getCodiAgent2() == null ? "" : sequera.getCodiAgent2());
        }
    }
}