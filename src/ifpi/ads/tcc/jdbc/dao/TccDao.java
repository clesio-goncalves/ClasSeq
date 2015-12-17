package ifpi.ads.tcc.jdbc.dao;

import ifpi.ads.tcc.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TccDao {

	private final Connection connection;

	public TccDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public Boolean desconsideraVerbo(String verbo) {
		try {

			Boolean resultado = false;

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from desconsidera_verbos where verbo like '"
							+ verbo + "';");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (verbo.equals(rs.getString("verbo"))) {
					resultado = true;
				}
			}

			rs.close();
			stmt.close();
			return resultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String baseAcoes(String verbo) {
		try {

			String resultado = verbo;

			PreparedStatement stmt = this.connection
					.prepareStatement("select palavra from base_acoes where id = (select sugestao from base_acoes where palavra like '"
							+ verbo + "');");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				resultado = rs.getString("palavra");
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Boolean pertenceBaseSufixo(String ator) {
		try {

			Boolean resultado = false;

			PreparedStatement stmt = this.connection
					.prepareStatement("select sufixo from base_sufixo;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (ator.endsWith(rs.getString("sufixo"))) {
					resultado = true;
				}
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String reducaoPlural(String palavra) {
		try {
			String resultado = palavra;

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from reducao_plural;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (resultado.endsWith(rs.getString("remover_sufixo"))) {
					resultado = palavra.substring(0, palavra.length()
							- rs.getString("remover_sufixo").length())
							+ rs.getString("substituir_sufixo");

					// Se o tamanho do radical for maior que o tamanho minimo,
					// termina a execução
					if (resultado.length() >= rs.getInt("tamanho_minimo")) {
						rs.close();
						stmt.close();
						return resultado;
					} else {
						resultado = palavra;
					}
				}
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String reducaoFeminino(String palavra) {
		try {
			String resultado = palavra;

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from reducao_feminino;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (resultado.endsWith(rs.getString("remover_sufixo"))) {
					resultado = palavra.substring(0, palavra.length()
							- rs.getString("remover_sufixo").length())
							+ rs.getString("substituir_sufixo");

					// Se o tamanho do radical for maior que o tamanho minimo,
					// termina a execução
					if (resultado.length() >= rs.getInt("tamanho_minimo")) {
						rs.close();
						stmt.close();
						return resultado;
					} else {
						resultado = palavra;
					}

				}
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String reducaoAumentativo(String palavra) {
		try {
			String resultado = palavra;

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from reducao_aumentativo;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (resultado.endsWith(rs.getString("remover_sufixo"))) {
					resultado = palavra.substring(0, palavra.length()
							- rs.getString("remover_sufixo").length())
							+ rs.getString("substituir_sufixo");

					// Se o tamanho do radical for maior que o tamanho minimo,
					// termina a execução
					if (resultado.length() >= rs.getInt("tamanho_minimo")) {
						rs.close();
						stmt.close();
						return resultado;
					} else {
						resultado = palavra;
					}

				}
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String reducaoNominal(String nome) {
		try {
			String resultado = nome;

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from reducao_nominal;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (resultado.endsWith(rs.getString("remover_sufixo"))) {
					resultado = nome.substring(0,
							nome.length()
									- rs.getString("remover_sufixo").length())
							+ rs.getString("substituir_sufixo");

					// Se o tamanho do radical for maior que o tamanho minimo,
					// termina a execução
					if (resultado.length() >= rs.getInt("tamanho_minimo")) {
						rs.close();
						stmt.close();
						return resultado;
					} else {
						resultado = nome;
					}

				}
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String remocaoVogalTematica(String nome) {
		try {
			String resultado = nome;

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from remocao_vogal_tematica;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (resultado.endsWith(rs.getString("remover_sufixo"))) {
					resultado = nome.substring(0,
							nome.length()
									- rs.getString("remover_sufixo").length());

					// Se o tamanho do radical for maior que o tamanho minimo,
					// termina a execução
					if (resultado.length() >= rs.getInt("tamanho_minimo")) {
						rs.close();
						stmt.close();
						return resultado;
					} else {
						resultado = nome;
					}

				}
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public String reducaoVerbal(String verbo) {
		try {
			String resultado = verbo;

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from reducao_verbal;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				if (resultado.endsWith(rs.getString("remover_sufixo"))) {
					resultado = verbo.substring(0, verbo.length()
							- rs.getString("remover_sufixo").length());

					// Se o tamanho do radical for maior que o tamanho minimo,
					// termina a execução
					if (resultado.length() >= rs.getInt("tamanho_minimo")) {
						rs.close();
						stmt.close();
						return resultado;
					} else {
						resultado = verbo;
					}

				}
			}

			rs.close();
			stmt.close();
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
