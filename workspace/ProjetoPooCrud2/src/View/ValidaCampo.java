package View;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidaCampo extends PlainDocument 
{
	int tam=0;
	String regex ="" ;
	
	public ValidaCampo(int a,String reg ) 
	{
		// TODO Auto-generated constructor stub
		this.tam=a;
		this.regex=reg;
		
		
	}
	
	// metodo utilizado para limitação de campos e validação da entrada dos tipos de dados String e númerico
	
	@Override
	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException 
	{
		
		
		// TODO Auto-generated method stub
		
		
		int tamanho= this.getLength() + str.length();
		
		if(tamanho<=tam)
		{
			super.insertString(offs, str.replaceAll(regex, ""), a);
		}
		else
		{
			
		}
	}
	
}
