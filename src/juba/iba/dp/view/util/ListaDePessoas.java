package juba.iba.dp.view.util;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import juba.iba.dp.model.Pessoa;
import juba.iba.dp.model.db.DBService;


public class ListaDePessoas extends AbstractListModel<Pessoa> {
	private static final long serialVersionUID = -8676225501649446553L;

	private String[] pessoas;
	
	public ListaDePessoas(FiltroDePessoas filtro) {
		String[] arquivos = DBService.getListFiles();
		
		if (filtro.isAlgumFiltro()) {
			ArrayList<String> temp = new ArrayList<String>();
			
			for (String filename : arquivos) {
				try {
					Pessoa pessoa = DBService.getPessoa(filename);
					
					if (filtro.isFiltroIdade()) {
						if (!pessoa.getFaixaEtaria().equals(filtro.getFaixaEtaria())) {
							continue;
						}
					}
					
					if (filtro.isFiltroFezLicao()) {
						switch (filtro.getLicaoSim()) {
						case 1:
							if (!pessoa.getLicoes().isUm()) continue;
							break;
						case 2:
							if (!pessoa.getLicoes().isDois()) continue;
							break;
						case 3:
							if (!pessoa.getLicoes().isTres()) continue;
							break;
						case 4:
							if (!pessoa.getLicoes().isQuatro()) continue;
							break;
						case 5:
							if (!pessoa.getLicoes().isCinco()) continue;
							break;
						case 6:
							if (!pessoa.getLicoes().isSeis()) continue;
							break;
						case 7:
							if (!pessoa.getLicoes().isSete()) continue;
							break;
						default:
							break;
						}
					}

					if (filtro.isFiltroNaoFezLicao()) {
						switch (filtro.getLicaoNao()) {
						case 1:
							if (pessoa.getLicoes().isUm()) continue;
							break;
						case 2:
							if (pessoa.getLicoes().isDois()) continue;
							break;
						case 3:
							if (pessoa.getLicoes().isTres()) continue;
							break;
						case 4:
							if (pessoa.getLicoes().isQuatro()) continue;
							break;
						case 5:
							if (pessoa.getLicoes().isCinco()) continue;
							break;
						case 6:
							if (pessoa.getLicoes().isSeis()) continue;
							break;
						case 7:
							if (pessoa.getLicoes().isSete()) continue;
							break;
						default:
							break;
						}
					}
					
					temp.add(filename);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			pessoas = temp.toArray(new String[temp.size()]); 
		} else {
			pessoas = arquivos;
		}
	}

	@Override
	public Pessoa getElementAt(int index) {
		try {
			return DBService.getPessoa(pessoas[index]);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int getSize() {
		return pessoas.length;
	}

}
