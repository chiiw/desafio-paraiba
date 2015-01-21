package juba.iba.dp.model.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import juba.iba.dp.model.Pessoa;

public class DBService {
	private final static String DIR = "dp_data";
	static {
		try {
			new File(DIR).mkdir();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void persist(Pessoa pessoa, boolean editando) throws Exception {
		File file = new File(DIR, pessoa.getNomeArquivo());
		
		if (!editando) {
			if (file.exists()) {
				throw new Exception("Já existe um cadastro com o mesmo nome!");
			}
			file.createNewFile();			
		}
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(pessoa);
		out.close();
	}
	
	public static String[] getListFiles() {
		File dir = new File(DIR);
		String[] files = dir.list();
//		Arrays.sort(files);
		return files;
	}
	
	public static Pessoa getPessoa(String filename) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(DIR, filename)));
		Object obj = in.readObject();
		in.close();
		return (Pessoa) obj;
	}

	public static void excluir(Pessoa pessoa) {
		File file = new File(DIR, pessoa.getNomeArquivo());
		file.delete();
	}
}
