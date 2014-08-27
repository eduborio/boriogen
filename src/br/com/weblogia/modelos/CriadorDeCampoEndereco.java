package br.com.weblogia.modelos;

import java.lang.reflect.Field;

public class CriadorDeCampoEndereco extends TemplateDeTiposDeCampos {

	public CriadorDeCampoEndereco(SqlFieldBuilder criador) {
		super(criador);
	}

	@Override
	public boolean ehDoTipoEsperado(Field field) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String costroiCampoDeSql(Field field) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
		("  \'logradouro\' varchar(55) DEFAULT NULL,");
		("  \'numero\' varchar(9) DEFAULT NULL,");
		("  \'bairro\' varchar(20) DEFAULT NULL,");
		("  \'cep\' varchar(8) DEFAULT NULL,");
		("  \'complemento\' varchar(20) DEFAULT NULL,");
		("  \'telefone\' varchar(10) DEFAULT NULL,");
		("  \'id_municipio\' int(10) unsigned DEFAULT NULL,");	
	}*/

}
