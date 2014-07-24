/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cat.creaf.afectaciobosc.www.controllers;

import Excel.TransformadorXLS;
import MSIPANBasicObj.ObjecteSIPAN;
import cat.creaf.afectaciobosc.model.DanyAbiotic;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class TransformadorDanyAbioticXLS
    implements TransformadorXLS
{

    private SimpleDateFormat spdf;
    
    public TransformadorDanyAbioticXLS()
    {
        spdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    public void transformar(Object obj, HSSFRow row)
    {
        if(obj instanceof ObjecteSIPAN)
        {
            DanyAbiotic dm = (DanyAbiotic)obj;
            HSSFCell cell = row.createCell(0);
            cell.setCellValue(dm.getIdString());
            cell = row.createCell(1);
            cell.setCellValue(dm.getComarca() == null ? "" : dm.getComarca().toString());
            cell = row.createCell(2);
            cell.setCellValue(dm.getData() == null ? "" : spdf.format(dm.getData()));
            cell = row.createCell(3);
            String especie1 = "";
            String grauAfect = "";
            if(dm.getAfectacionsEstimades().size()>0 &&
                    dm.getAfectacionsEstimades().get(0).getEspecie()!=null){
                especie1 = dm.getAfectacionsEstimades().get(0).getEspecie().toString();
                grauAfect = dm.getAfectacionsEstimades().get(0).getAfectacio();
            }
            cell.setCellValue(especie1);
            cell = row.createCell(4);
            cell.setCellValue(grauAfect);
            cell = row.createCell(5);
            cell.setCellValue(dm.getCodi());
            cell = row.createCell(6);
            String area = "";
            if(dm.getAreaAfectada()!=null){
                DecimalFormat df = new DecimalFormat("#0.00");
                area = df.format(dm.getAreaAfectada().getArea()/10000);
            }
            cell.setCellValue(area);
            cell = row.createCell(7);
            cell.setCellValue(dm.getCodiAgent1() == null ? "" : dm.getCodiAgent1());
            cell = row.createCell(8);
            cell.setCellValue(dm.getCodiAgent2() == null ? "" : dm.getCodiAgent2());
        }
    }
}