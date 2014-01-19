package SAPSproWCalculations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public final class Calc {
	
	private static final BigDecimal density = new BigDecimal(7.85);
	public static final BigDecimal bil = new BigDecimal(1000000);
	//private static final MathContext mc00 = new MathContext(6);
 
	// Метод для заполнения массива.
	@SuppressWarnings("resource")
	public static void fillArrayList (ArrayList<String> list, File file){
		list.clear();
		BufferedReader in = null;
        try {   
            in = new BufferedReader(new FileReader(file));
            String str;
            //Заполнение массива myList строками из файла TT
            while ((str = in.readLine()) != null) {
                list.add(str);
            }  
        } 
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } 
        catch (IOException e2) {
            e2.printStackTrace();
        } 
	}
	
	
	// Метод для заполнения текстового поля
	public static void setContentToJTextArea (ArrayList<String> list, JTextArea area){
		area.setText("");;
		for (int i = 0; i < list.size(); i++){
			area.append((String)list.get(i));
			area.append("\n");
		}
		
	}
	
	
	// Заполнение Плошадь всего

    /*When a MathContext object is supplied with a precision setting of 0 (for example, MathContext.UNLIMITED), arithmetic operations are exact, as are 
     * the arithmetic methods which take no MathContext object. (This is the only behavior that was supported in releases prior to 5.)
    As a corollary of computing the exact result, the rounding mode setting of a MathContext object with a precision setting of 0 is not used and thus irrelevant. 
    In the case of divide, the exact quotient could have an infinitely long decimal expansion; for example, 1 divided by 3.
    If the quotient has a nonterminating decimal expansion and the operation is specified to return an exact result, an ArithmeticException is thrown. 
    Otherwise, the exact result of the division is returned, as done for other operations.
	To fix, you need to do something like this:

	a.divide(b, 2, RoundingMode.HALF_UP)

	where 2 is precision and RoundingMode.HALF_UP is rounding mode*/

	public static void fillTotalArea (ArrayList<String> list, JTextField field){
		String totalArea = null;
		BigDecimal area = null;
		String temp = null;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).startsWith("#32 Расход материала")){
				temp = list.get(i+1).replace(",", ".");
				area = (((new BigDecimal(temp).divide(density,10,RoundingMode.HALF_UP)).divide(getThickness(list),10,RoundingMode.HALF_UP)).multiply(bil));
				totalArea = (area.setScale(0, RoundingMode.HALF_UP)).toString();
			}
		}
		field.setText(totalArea);
	}
	
	public static void fillDetailArea (ArrayList<String> list, JTextField field){
		String totalArea = null;
		BigDecimal area = null;
		String temp = null;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).startsWith("#23 Детали")){
				temp = list.get(i+1).replace(",", ".");
				area = (((new BigDecimal(temp).divide(density,10,RoundingMode.HALF_UP)).divide(getThickness(list),10,RoundingMode.HALF_UP)).multiply(bil));
				totalArea = (area.setScale(0, RoundingMode.HALF_UP)).toString();
			}
		}
		field.setText(totalArea);
	}
	
	public static BigDecimal getThickness (ArrayList<String> list){
		String temp = null;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).startsWith("#3 Габариты листа")){
				temp = list.get(i+3).replace(",", ".");
				//System.out.println(temp);
			}	
		}
		BigDecimal thickness = new BigDecimal(temp);
		return thickness;
	}
	
	public static void fillLabel (ArrayList<String> list, JLabel label, String str){
		label.setText(str + list.get(1));
		
	}
	
	// Периметр реза
	public static void fillСutLength (ArrayList<String> list, JTextField field){
		String cutLength = null;
		String temp = null;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).startsWith("#9 Резать")){
				temp = list.get(i+1).replace(",", ".");
				cutLength = ((new BigDecimal(temp).multiply(new BigDecimal(1000)).setScale(3, RoundingMode.HALF_UP))).toString();
			}
		}
		field.setText(cutLength);
	}
	
	//Площадь лома
	public static void fillScrapArea (ArrayList<String> list, JTextField field){
		String totalArea = null;
		BigDecimal area = null;
		String temp = null;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).startsWith("#25 Отход")){
				temp = list.get(i+1).replace(",", ".");
				area = (((new BigDecimal(temp).divide(density,10,RoundingMode.HALF_UP)).divide(getThickness(list),10,RoundingMode.HALF_UP)).multiply(bil));
				totalArea = (area.setScale(0, RoundingMode.HALF_UP)).toString();
			}
		}
		field.setText(totalArea);
	}
	
	// Площадь угара
	public static void fillWasteArea (ArrayList<String> list, JTextField field){
		String totalArea = null;
		BigDecimal area = null;
		String temp = null;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).startsWith("#27 Сгоревший металл")){
				temp = list.get(i+1).replace(",", ".");
				area = (((new BigDecimal(temp).divide(density,10,RoundingMode.HALF_UP)).divide(getThickness(list),10,RoundingMode.HALF_UP)).multiply(bil));
				totalArea = (area.setScale(0, RoundingMode.HALF_UP)).toString();
			}
		}
		field.setText(totalArea);
	}
	
	//Количество пробивок
	public static void fillPierceNumber (ArrayList<String> list, JTextField field){
		String pierceNumber = null;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).startsWith("#10 Ввод")){
				pierceNumber = list.get(i+1);
			}
		}
		field.setText(pierceNumber);
	}
	
	//Общее время
	public static void setTotalTime (ArrayList<String> list, JTextField field){
		String time = null;
		for (int i = 0; i < list.size(); i++){
			if (list.get(i).startsWith("#31 ОБЩЕЕ ВРЕМЯ")){
				time = list.get(i+1) +":" + list.get(i+2) +":" + list.get(i+3);
			}
		}
		field.setText(time);
		
	}
	
}
