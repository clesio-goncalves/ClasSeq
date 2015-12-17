function comprova_extensao(formulario, arquivo) {
	extensoes_permitidas = new Array(".txt", ".story", ".pdf", ".doc");
	if (arquivo) {
		extensao = (arquivo.substring(arquivo.lastIndexOf("."))).toLowerCase();
		permite = false;
		for (var i = 0; i < extensoes_permitidas.length; i++) {
			if (extensoes_permitidas[i] == extensao) {
				permite = true;
				break;
			}
		}
		if (!permite) {
			alert("EXTENSÃO DO ARQUIVO NÃO PERMITIDA!\n"
					+ "Extensões permitidas:\n" + "Documento de texto (.txt)\n"
					+ "Estoria JBehave (.story)\n Documento Word (.doc)\n "
					+ "Portable Document Format (PDF)");

			return false;
		}
		// Pega a extensão e coloca em nome
		var nome_extensao = document.getElementById('extensao');
		nome_extensao.value = extensao;

		formulario.submit();
		return true;
	}

	return false;

}