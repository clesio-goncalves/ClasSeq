package ifpi.ads.tcc.exportar;

import ifpi.ads.tcc.padroes.DiagramaDeClasse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMI {

	private String estoriaXmi21;
	private String estoriaXmi12;
	private DiagramaDeClasse diagramaDeClasse;

	public XMI(DiagramaDeClasse diagramaDeClasse) {
		this.diagramaDeClasse = diagramaDeClasse;
	}

	public void gerarXMI21() {
		try {
			int indice = 1;
			String tipoDado = null;
			Boolean contemDouble = false;
			String[] metodo = null;
			String[] parametro = null;
			String ator = this.diagramaDeClasse.getAtor();
			StringBuilder coveredByAtor = new StringBuilder();
			StringBuilder coveredByClasse = new StringBuilder();
			Map<String, String> mapCoveredByClasse = new HashMap<String, String>();
			List<String> listaReferenciaMetodo = new ArrayList<String>();

			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = docFactory.newDocumentBuilder();

			Document doc = documentBuilder.newDocument();

			// --> uml:Model <-- //
			Element model = doc.createElement("uml:Model");

			// xmlns:uml
			Attr uml = doc.createAttribute("xmlns:uml");
			uml.setValue("http://schema.omg.org/spec/UML/2.1.1");
			model.setAttributeNode(uml);

			// xmlns:xmi
			Attr xmi = doc.createAttribute("xmlns:xmi");
			xmi.setValue("http://schema.omg.org/spec/XMI/2.1");
			model.setAttributeNode(xmi);

			// xmi:version
			Attr version = doc.createAttribute("xmi:version");
			version.setValue("2.1");
			model.setAttributeNode(version);

			// xmi:id
			Attr id = doc.createAttribute("xmi:id");
			id.setValue("_EstoriaUsuario");
			model.setAttributeNode(id);

			// name
			Attr name = doc.createAttribute("name");
			name.setValue("EstoriaUsuario");
			model.setAttributeNode(name);

			doc.appendChild(model);

			// --> eAnnotations <-- //
			Element eAnnotations = doc.createElement("eAnnotations");

			// xmi:id
			id = doc.createAttribute("xmi:id");
			id.setValue("_eAnnotations");
			eAnnotations.setAttributeNode(id);

			// source
			Attr source = doc.createAttribute("source");
			source.setValue("Objing");
			eAnnotations.setAttributeNode(source);

			model.appendChild(eAnnotations);

			// --> contents <-- //
			Element contents = doc.createElement("contents");

			// xmi:type
			Attr type = doc.createAttribute("xmi:type");
			type.setValue("uml:Property");
			contents.setAttributeNode(type);

			// xmi:id
			id = doc.createAttribute("xmi:id");
			id.setValue("_contents");
			contents.setAttributeNode(id);

			// name
			name = doc.createAttribute("name");
			name.setValue("exporterVersion");
			contents.setAttributeNode(name);

			eAnnotations.appendChild(contents);

			// --> defaultValue <-- //
			Element defaultValue = doc.createElement("defaultValue");

			// xmi:type
			type = doc.createAttribute("xmi:type");
			type.setValue("uml:LiteralString");
			defaultValue.setAttributeNode(type);

			// xmi:id
			id = doc.createAttribute("xmi:id");
			id.setValue("_defaultValue");
			defaultValue.setAttributeNode(id);

			// value
			Attr value = doc.createAttribute("value");
			value.setValue("3.0.0");
			defaultValue.setAttributeNode(value);

			contents.appendChild(defaultValue);

			// ----- DIAGRAMA DE CLASSE ----- //

			// --> packagedElement <-- //
			Element modelPackagedElement = doc.createElement("packagedElement");

			// xmi:type
			type = doc.createAttribute("xmi:type");
			type.setValue("uml:Package");
			modelPackagedElement.setAttributeNode(type);

			// xmi:id
			id = doc.createAttribute("xmi:id");
			id.setValue("_DiagramaDeClasse");
			modelPackagedElement.setAttributeNode(id);

			// name
			name = doc.createAttribute("name");
			name.setValue("DiagramaDeClasse");
			modelPackagedElement.setAttributeNode(name);

			model.appendChild(modelPackagedElement);

			// CLASSES //
			for (String key : this.diagramaDeClasse.getDiagramaDeClasse()
					.keySet()) {

				// --> packagedElement <-- //
				Element packagedElement = doc.createElement("packagedElement");

				// xmi:type
				type = doc.createAttribute("xmi:type");
				type.setValue("uml:Class");
				packagedElement.setAttributeNode(type);

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_" + key);
				packagedElement.setAttributeNode(id);

				// name
				name = doc.createAttribute("name");
				name.setValue(key);
				packagedElement.setAttributeNode(name);

				modelPackagedElement.appendChild(packagedElement);

				// ATRIBUTOS E MÉTODOS
				for (String valor : this.diagramaDeClasse.getDiagramaDeClasse()
						.get(key)) {

					// ATRIBUTO
					if (valor.contains("_")) {
						String[] atributo = valor.split("_");

						// Selecionar o tipo de dado correto
						switch (atributo[0]) {
						case "String":
							tipoDado = "http://schema.omg.org/spec/UML/2.1.1/uml.xml#String";
							break;

						case "Integer":
							tipoDado = "http://schema.omg.org/spec/UML/2.1.1/uml.xml#Integer";
							break;

						case "Boolean":
							tipoDado = "http://schema.omg.org/spec/UML/2.1.1/uml.xml#Boolean";
							break;

						case "Double":
							tipoDado = "Double";
							contemDouble = true;
							break;

						default:
							break;
						}

						// --> ownedAttribute <-- //
						Element ownedAttribute = doc
								.createElement("ownedAttribute");

						// xmi:type
						type = doc.createAttribute("xmi:type");
						type.setValue("uml:Property");
						ownedAttribute.setAttributeNode(type);

						// xmi:id
						id = doc.createAttribute("xmi:id");
						id.setValue("_" + atributo[0] + atributo[1]);
						ownedAttribute.setAttributeNode(id);

						// name
						name = doc.createAttribute("name");
						name.setValue(atributo[1]);
						ownedAttribute.setAttributeNode(name);

						// visibility
						Attr visibility = doc.createAttribute("visibility");
						visibility.setValue("private");
						ownedAttribute.setAttributeNode(visibility);

						// Cria o tipo de dado Double
						if (tipoDado.equals("Double")) {
							// type
							type = doc.createAttribute("type");
							type.setValue("_Double");
							ownedAttribute.setAttributeNode(type);
						} else {
							// --> type <-- //
							Element elementType = doc.createElement("type");

							// xmi:type
							type = doc.createAttribute("xmi:type");
							type.setValue("uml:PrimitiveType");
							elementType.setAttributeNode(type);

							// href
							Attr href = doc.createAttribute("href");
							href.setValue(tipoDado);
							elementType.setAttributeNode(href);

							ownedAttribute.appendChild(elementType);
						}

						packagedElement.appendChild(ownedAttribute);

						// MÉTODO
					} else {
						metodo = valor.split("\\(");
						parametro = metodo[1].replace(")", "").split(" ");
						metodo[1] = null;

						// --> ownedOperation <-- //
						Element ownedOperation = doc
								.createElement("ownedOperation");

						// xmi:type
						type = doc.createAttribute("xmi:type");
						type.setValue("uml:Operation");
						ownedOperation.setAttributeNode(type);

						// xmi:id
						id = doc.createAttribute("xmi:id");
						id.setValue("_" + metodo[0] + parametro[0]);
						ownedOperation.setAttributeNode(id);

						// name
						name = doc.createAttribute("name");
						name.setValue(metodo[0]);
						ownedOperation.setAttributeNode(name);

						// visibility
						Attr visibility = doc.createAttribute("visibility");
						visibility.setValue("public");
						ownedOperation.setAttributeNode(visibility);

						packagedElement.appendChild(ownedOperation);

						// PARÂMETRO

						// --> ownedParameter <-- //
						Element ownedParameter = doc
								.createElement("ownedParameter");

						// xmi:id
						id = doc.createAttribute("xmi:id");
						id.setValue("_parametro" + parametro[0] + (indice++));
						ownedParameter.setAttributeNode(id);

						// name
						name = doc.createAttribute("name");
						name.setValue(parametro[1]);
						ownedParameter.setAttributeNode(name);

						// type
						type = doc.createAttribute("type");
						type.setValue("_" + parametro[0]);
						ownedParameter.setAttributeNode(type);

						ownedOperation.appendChild(ownedParameter);
					}
				}
			}

			indice = 1;
			int contAssociacao = 1;

			// ASSOCIAÇÃO //
			for (String key : this.diagramaDeClasse.getRelacionamento()
					.keySet()) {

				String[] tipo_relacionamento = key.split(":");

				for (String valor : this.diagramaDeClasse.getRelacionamento()
						.get(key)) {

					String[] classe_relacionamento = valor.split(":");

					// --> packagedElement <-- //
					Element packagedElement = doc
							.createElement("packagedElement");

					// xmi:type
					type = doc.createAttribute("xmi:type");
					type.setValue("uml:Association");
					packagedElement.setAttributeNode(type);

					// xmi:id
					id = doc.createAttribute("xmi:id");
					id.setValue("_association" + contAssociacao);
					packagedElement.setAttributeNode(id);

					// memberEnd
					Attr memberEnd = doc.createAttribute("memberEnd");
					memberEnd.setValue("_" + contAssociacao
							+ classe_relacionamento[0] + tipo_relacionamento[0]
							+ " _" + contAssociacao + classe_relacionamento[1]
							+ tipo_relacionamento[1]);
					packagedElement.setAttributeNode(memberEnd);

					modelPackagedElement.appendChild(packagedElement);

					for (int i = 0; i < classe_relacionamento.length; i++) {

						// --> ownedEnd <-- //
						Element ownedEnd = doc.createElement("ownedEnd");

						// xmi:type
						type = doc.createAttribute("xmi:type");
						type.setValue("uml:Property");
						ownedEnd.setAttributeNode(type);

						// xmi:id
						id = doc.createAttribute("xmi:id");
						id.setValue("_" + contAssociacao
								+ classe_relacionamento[i]
								+ tipo_relacionamento[i]);
						ownedEnd.setAttributeNode(id);

						// visibility
						Attr visibility = doc.createAttribute("visibility");
						visibility.setValue("public");
						ownedEnd.setAttributeNode(visibility);

						// type
						type = doc.createAttribute("type");
						type.setValue("_" + classe_relacionamento[i]);
						ownedEnd.setAttributeNode(type);

						// association
						Attr association = doc.createAttribute("association");
						association.setValue("_association" + contAssociacao);
						ownedEnd.setAttributeNode(association);

						packagedElement.appendChild(ownedEnd);

						// Cria a relação de N
						if (tipo_relacionamento[i].equals("n")) {

							// --> upperValue <-- //
							Element upperValue = doc
									.createElement("upperValue");

							// xmi:type
							type = doc.createAttribute("xmi:type");
							type.setValue("uml:LiteralUnlimitedNatural");
							upperValue.setAttributeNode(type);

							// xmi:id
							id = doc.createAttribute("xmi:id");
							id.setValue("_upperValue" + indice);
							upperValue.setAttributeNode(id);

							// value
							value = doc.createAttribute("value");
							value.setValue("*");
							upperValue.setAttributeNode(value);

							ownedEnd.appendChild(upperValue);

							// --> lowerValue <-- //
							Element lowerValue = doc
									.createElement("lowerValue");

							// xmi:type
							type = doc.createAttribute("xmi:type");
							type.setValue("uml:LiteralInteger");
							lowerValue.setAttributeNode(type);

							// xmi:id
							id = doc.createAttribute("xmi:id");
							id.setValue("_lowerValue" + indice);
							lowerValue.setAttributeNode(id);

							ownedEnd.appendChild(lowerValue);

							indice++;

						}

					}

					contAssociacao++;

				}

			}

			// ----- DIAGRAMA DE SEQUENCIA ----- //

			// Só tem diagrama de sequencia se tiver ator
			if (!ator.equals("")) {

				// --> packagedElement <-- //
				modelPackagedElement = doc.createElement("packagedElement");

				// xmi:type
				type = doc.createAttribute("xmi:type");
				type.setValue("uml:Package");
				modelPackagedElement.setAttributeNode(type);

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_DiagramaDeSequencia");
				modelPackagedElement.setAttributeNode(id);

				// name
				name = doc.createAttribute("name");
				name.setValue("DiagramaDeSequencia");
				modelPackagedElement.setAttributeNode(name);

				model.appendChild(modelPackagedElement);

				// --> packagedElement <-- //
				Element packagedElement = doc.createElement("packagedElement");

				// xmi:type
				type = doc.createAttribute("xmi:type");
				type.setValue("uml:Interaction");
				packagedElement.setAttributeNode(type);

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_Interaction");
				packagedElement.setAttributeNode(id);

				// name
				name = doc.createAttribute("name");
				name.setValue("Interaction");
				packagedElement.setAttributeNode(name);

				modelPackagedElement.appendChild(packagedElement);

				// --> nestedClassifier <-- //
				Element nestedClassifier = doc
						.createElement("nestedClassifier");

				// xmi:type
				type = doc.createAttribute("xmi:type");
				type.setValue("uml:Collaboration");
				nestedClassifier.setAttributeNode(type);

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_Collaboration");
				nestedClassifier.setAttributeNode(id);

				// name
				name = doc.createAttribute("name");
				name.setValue("locals");
				nestedClassifier.setAttributeNode(name);

				packagedElement.appendChild(nestedClassifier);

				// CLASSES
				for (String key : this.diagramaDeClasse.getDiagramaDeClasse()
						.keySet()) {

					// --> ownedAttribute <-- //
					Element ownedAttribute = doc
							.createElement("ownedAttribute");

					// xmi:type
					type = doc.createAttribute("xmi:type");
					type.setValue("uml:Property");
					ownedAttribute.setAttributeNode(type);

					// xmi:id
					id = doc.createAttribute("xmi:id");
					id.setValue("_Collaboration" + key);
					ownedAttribute.setAttributeNode(id);

					// name
					name = doc.createAttribute("name");
					name.setValue(key.toLowerCase());
					ownedAttribute.setAttributeNode(name);

					// type
					type = doc.createAttribute("type");
					type.setValue("_" + key);
					ownedAttribute.setAttributeNode(type);

					// aggregation
					Attr aggregation = doc.createAttribute("aggregation");
					aggregation.setValue("composite");
					ownedAttribute.setAttributeNode(aggregation);

					nestedClassifier.appendChild(ownedAttribute);

				}

				// ATOR

				// "_inicioFocoControle" + Ator

				// --> fragment <-- //
				Element fragment = doc.createElement("fragment");

				// xmi:type
				type = doc.createAttribute("xmi:type");
				type.setValue("uml:ExecutionOccurrenceSpecification");
				fragment.setAttributeNode(type);

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_inicioFocoControle" + ator);
				fragment.setAttributeNode(id);
				coveredByAtor.append("_inicioFocoControle" + ator);

				// covered
				Attr covered = doc.createAttribute("covered");
				covered.setValue("_lifeline" + ator);
				fragment.setAttributeNode(covered);

				packagedElement.appendChild(fragment);

				// "_focoControle" + Ator

				// --> fragment <-- //
				fragment = doc.createElement("fragment");

				// xmi:type
				type = doc.createAttribute("xmi:type");
				type.setValue("uml:BehaviorExecutionSpecification");
				fragment.setAttributeNode(type);

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_focoControle" + ator);
				fragment.setAttributeNode(id);
				coveredByAtor.append(" _focoControle" + ator);

				// covered
				covered = doc.createAttribute("covered");
				covered.setValue("_lifeline" + ator);
				fragment.setAttributeNode(covered);

				// start
				Attr start = doc.createAttribute("start");
				start.setValue("_inicioFocoControle" + ator);
				fragment.setAttributeNode(start);

				// finish
				Attr finish = doc.createAttribute("finish");
				finish.setValue("_fimFocoControle" + ator);
				fragment.setAttributeNode(finish);

				packagedElement.appendChild(fragment);

				// PEGA AS AÇÕES
				indice = 1;
				for (String key : this.diagramaDeClasse.getDiagramaDeClasse()
						.keySet()) {
					if (!ator.equals(key)) {
						for (String valor : this.diagramaDeClasse
								.getDiagramaDeClasse().get(key)) {

							if (!valor.contains("_")) {

								// adiciona espaço no coveredByClasse, caso
								// tenha mais de uma lifiline fora o ator
								if (indice != 1) {
									coveredByClasse.append(" ");
								}

								metodo = valor.split("\\(");
								parametro = metodo[1].replace(")", "").split(
										" ");
								metodo[1] = null;

								// ENVIA MENSAGEM

								// --> fragment <-- //
								fragment = doc.createElement("fragment");

								// xmi:type
								type = doc.createAttribute("xmi:type");
								type.setValue("uml:MessageOccurrenceSpecification");
								fragment.setAttributeNode(type);

								// xmi:id
								id = doc.createAttribute("xmi:id");
								id.setValue("_envia" + metodo[0] + parametro[0]);
								fragment.setAttributeNode(id);
								coveredByAtor.append(" _envia" + metodo[0]
										+ parametro[0]);

								// covered
								covered = doc.createAttribute("covered");
								covered.setValue("_lifeline" + ator);
								fragment.setAttributeNode(covered);

								// event
								Attr event = doc.createAttribute("event");
								event.setValue("_evento1" + metodo[0]
										+ parametro[0]);
								fragment.setAttributeNode(event);
								listaReferenciaMetodo.add(metodo[0]
										+ parametro[0]);

								// message
								Attr message = doc.createAttribute("message");
								message.setValue("_mensagem1" + metodo[0]
										+ parametro[0]);
								fragment.setAttributeNode(message);

								packagedElement.appendChild(fragment);

								// 3 FRAGMENTOS -> FOCO DE CONTROLE

								// "_inicioFocoControle" + Key

								// --> fragment <-- //
								fragment = doc.createElement("fragment");

								// xmi:type
								type = doc.createAttribute("xmi:type");
								type.setValue("uml:MessageOccurrenceSpecification");
								fragment.setAttributeNode(type);

								// xmi:id
								id = doc.createAttribute("xmi:id");
								id.setValue("_inicioFocoControle" + indice
										+ key);
								fragment.setAttributeNode(id);
								coveredByClasse.append("_inicioFocoControle"
										+ indice + key);

								// covered
								covered = doc.createAttribute("covered");
								covered.setValue("_lifeline" + key);
								fragment.setAttributeNode(covered);

								// event
								event = doc.createAttribute("event");
								event.setValue("_evento2" + metodo[0]
										+ parametro[0]);
								fragment.setAttributeNode(event);

								// message
								message = doc.createAttribute("message");
								message.setValue("_mensagem1" + metodo[0]
										+ parametro[0]);
								fragment.setAttributeNode(message);

								packagedElement.appendChild(fragment);

								// "_focoControle" + Key
								// --> fragment <-- //
								fragment = doc.createElement("fragment");

								// xmi:type
								type = doc.createAttribute("xmi:type");
								type.setValue("uml:BehaviorExecutionSpecification");
								fragment.setAttributeNode(type);

								// xmi:id
								id = doc.createAttribute("xmi:id");
								id.setValue("_focoControle" + indice + key);
								fragment.setAttributeNode(id);
								coveredByClasse.append(" _focoControle"
										+ indice + key);

								// covered
								covered = doc.createAttribute("covered");
								covered.setValue("_lifeline" + key);
								fragment.setAttributeNode(covered);

								// start
								start = doc.createAttribute("start");
								start.setValue("_inicioFocoControle" + indice
										+ key);
								fragment.setAttributeNode(start);

								// finish
								finish = doc.createAttribute("finish");
								finish.setValue("_fimFocoControle" + indice
										+ key);
								fragment.setAttributeNode(finish);

								packagedElement.appendChild(fragment);

								// "_fimFocoControle" + Key
								// --> fragment <-- //
								fragment = doc.createElement("fragment");

								// xmi:type
								type = doc.createAttribute("xmi:type");
								type.setValue("uml:MessageOccurrenceSpecification");
								fragment.setAttributeNode(type);

								// xmi:id
								id = doc.createAttribute("xmi:id");
								id.setValue("_fimFocoControle" + indice + key);
								fragment.setAttributeNode(id);
								coveredByClasse.append(" _fimFocoControle"
										+ indice + key);

								// covered
								covered = doc.createAttribute("covered");
								covered.setValue("_lifeline" + key);
								fragment.setAttributeNode(covered);

								// message
								message = doc.createAttribute("message");
								message.setValue("_mensagem2" + metodo[0]
										+ parametro[0]);
								fragment.setAttributeNode(message);

								packagedElement.appendChild(fragment);

								// RECEBE MENSAGEM

								// --> fragment <-- //
								fragment = doc.createElement("fragment");

								// xmi:type
								type = doc.createAttribute("xmi:type");
								type.setValue("uml:MessageOccurrenceSpecification");
								fragment.setAttributeNode(type);

								// xmi:id
								id = doc.createAttribute("xmi:id");
								id.setValue("_recebe" + metodo[0]
										+ parametro[0]);
								fragment.setAttributeNode(id);
								coveredByAtor.append(" _recebe" + metodo[0]
										+ parametro[0]);

								// covered
								covered = doc.createAttribute("covered");
								covered.setValue("_lifeline" + ator);
								fragment.setAttributeNode(covered);

								// message
								message = doc.createAttribute("message");
								message.setValue("_mensagem2" + metodo[0]
										+ parametro[0]);
								fragment.setAttributeNode(message);

								packagedElement.appendChild(fragment);

								// MENSAGENS

								// --> message <-- //
								Element elementMessage = doc
										.createElement("message");

								// xmi:type
								type = doc.createAttribute("xmi:type");
								type.setValue("uml:Message");
								elementMessage.setAttributeNode(type);

								// xmi:id
								id = doc.createAttribute("xmi:id");
								id.setValue("_mensagem1" + metodo[0]
										+ parametro[0]);
								elementMessage.setAttributeNode(id);

								// receiveEvent
								Attr receiveEvent = doc
										.createAttribute("receiveEvent");
								receiveEvent.setValue("_inicioFocoControle"
										+ indice + key);
								elementMessage.setAttributeNode(receiveEvent);

								// sendEvent
								Attr sendEvent = doc
										.createAttribute("sendEvent");
								sendEvent.setValue("_envia" + metodo[0]
										+ parametro[0]);
								elementMessage.setAttributeNode(sendEvent);

								packagedElement.appendChild(elementMessage);

								// --> message <-- //
								elementMessage = doc.createElement("message");

								// xmi:type
								type = doc.createAttribute("xmi:type");
								type.setValue("uml:Message");
								elementMessage.setAttributeNode(type);

								// xmi:id
								id = doc.createAttribute("xmi:id");
								id.setValue("_mensagem2" + metodo[0]
										+ parametro[0]);
								elementMessage.setAttributeNode(id);

								// messageSort
								Attr messageSort = doc
										.createAttribute("messageSort");
								messageSort.setValue("reply");
								elementMessage.setAttributeNode(messageSort);

								// receiveEvent
								receiveEvent = doc
										.createAttribute("receiveEvent");
								receiveEvent.setValue("_recebe" + metodo[0]
										+ parametro[0]);
								elementMessage.setAttributeNode(receiveEvent);

								// sendEvent
								sendEvent = doc.createAttribute("sendEvent");
								sendEvent.setValue("_fimFocoControle" + indice
										+ key);
								elementMessage.setAttributeNode(sendEvent);

								packagedElement.appendChild(elementMessage);

								indice++;
							}
						}

						// Adiciona o coveredByClasse num Map para retorno nos
						// lifelines
						mapCoveredByClasse.put(key, coveredByClasse.toString());

						// Reinicia a classe
						coveredByClasse.delete(0, coveredByClasse.length());

						// Reinicia o indice
						indice = 1;

					}
				}

				// "_fimFocoControle" + Ator

				// --> fragment <-- //
				fragment = doc.createElement("fragment");

				// xmi:type
				type = doc.createAttribute("xmi:type");
				type.setValue("uml:ExecutionOccurrenceSpecification");
				fragment.setAttributeNode(type);

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_fimFocoControle" + ator);
				fragment.setAttributeNode(id);
				coveredByAtor.append(" _fimFocoControle" + ator);

				// covered
				covered = doc.createAttribute("covered");
				covered.setValue("_lifeline" + ator);
				fragment.setAttributeNode(covered);

				packagedElement.appendChild(fragment);

				// --> lifelineAtor <-- //
				Element lifeline = doc.createElement("lifeline");

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_lifeline" + ator);
				lifeline.setAttributeNode(id);

				// name
				name = doc.createAttribute("name");
				name.setValue(ator.toLowerCase());
				lifeline.setAttributeNode(name);

				// represents
				Attr represents = doc.createAttribute("represents");
				represents.setValue("_Collaboration" + ator);
				lifeline.setAttributeNode(represents);

				// coveredBy
				Attr coveredBy = doc.createAttribute("coveredBy");
				coveredBy.setValue(coveredByAtor.toString());
				lifeline.setAttributeNode(coveredBy);

				packagedElement.appendChild(lifeline);

				// Pega as outras lifelines
				for (String key : this.diagramaDeClasse.getDiagramaDeClasse()
						.keySet()) {
					if (!ator.equals(key)) {

						// --> lifeline <-- //
						lifeline = doc.createElement("lifeline");

						// xmi:id
						id = doc.createAttribute("xmi:id");
						id.setValue("_lifeline" + key);
						lifeline.setAttributeNode(id);

						// name
						name = doc.createAttribute("name");
						name.setValue(key.toLowerCase());
						lifeline.setAttributeNode(name);

						// represents
						represents = doc.createAttribute("represents");
						represents.setValue("_Collaboration" + key);
						lifeline.setAttributeNode(represents);

						// coveredBy
						coveredBy = doc.createAttribute("coveredBy");
						coveredBy.setValue(mapCoveredByClasse.get(key));
						lifeline.setAttributeNode(coveredBy);

						packagedElement.appendChild(lifeline);
					}
				}

				// Pega as referências para os métodos
				for (String referencia : listaReferenciaMetodo) {

					// --> packagedElement <-- //
					packagedElement = doc.createElement("packagedElement");

					// xmi:type
					type = doc.createAttribute("xmi:type");
					type.setValue("uml:SendOperationEvent");
					packagedElement.setAttributeNode(type);

					// xmi:id
					id = doc.createAttribute("xmi:id");
					id.setValue("_evento1" + referencia);
					packagedElement.setAttributeNode(id);

					// operation
					Attr operation = doc.createAttribute("operation");
					operation.setValue("_" + referencia);
					packagedElement.setAttributeNode(operation);

					modelPackagedElement.appendChild(packagedElement);

					// --> packagedElement <-- //
					packagedElement = doc.createElement("packagedElement");

					// xmi:type
					type = doc.createAttribute("xmi:type");
					type.setValue("uml:SendOperationEvent");
					packagedElement.setAttributeNode(type);

					// xmi:id
					id = doc.createAttribute("xmi:id");
					id.setValue("_evento2" + referencia);
					packagedElement.setAttributeNode(id);

					// operation
					operation = doc.createAttribute("operation");
					operation.setValue("_" + referencia);
					packagedElement.setAttributeNode(operation);

					modelPackagedElement.appendChild(packagedElement);

				}

			}

			// Verifica se no diagrama de classe contem atributo com o tipo de
			// dado Double
			if (contemDouble) {

				// --> packagedElement <-- //
				Element packagedElement = doc.createElement("packagedElement");

				// xmi:type
				type = doc.createAttribute("xmi:type");
				type.setValue("uml:PrimitiveType");
				packagedElement.setAttributeNode(type);

				// xmi:id
				id = doc.createAttribute("xmi:id");
				id.setValue("_Double");
				packagedElement.setAttributeNode(id);

				// name
				name = doc.createAttribute("name");
				name.setValue("double");
				packagedElement.setAttributeNode(name);

				model.appendChild(packagedElement);
			}

			// Cria os objetos que fazem referências à console e ao arquivo
			criaEstruturaXMI(doc, 21);

		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}

	public void gerarXMI12() {
		int indice = 0;
		String tipoDado = null;

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder documentBuilder = docFactory.newDocumentBuilder();

			Document doc = documentBuilder.newDocument();

			// XMI
			Element root = doc.createElement("XMI");

			// xmi.version
			Attr version = doc.createAttribute("xmi.version");
			version.setValue("1.2");
			root.setAttributeNode(version);

			// xmlns:UML
			Attr xmlns = doc.createAttribute("xmlns:UML");
			xmlns.setValue("org.omg.xmi.namespace.UML");
			root.setAttributeNode(xmlns);

			doc.appendChild(root);

			// XMI.header
			Element head = doc.createElement("XMI.header");
			root.appendChild(head);

			// XMI.documentation
			Element documentation = doc.createElement("XMI.documentation");
			head.appendChild(documentation);

			// XMI.exporter
			Element exporter = doc.createElement("XMI.exporter");

			exporter.appendChild(doc
					.createTextNode("TCC Analise e Desenvolvimento de Sistemas"));
			documentation.appendChild(exporter);

			// XMI.exporterVersion
			Element exporterVersion = doc.createElement("XMI.exporterVersion");
			exporterVersion
					.appendChild(doc
							.createTextNode("TCC Analise e Desenvolvimento de Sistemas"));
			documentation.appendChild(exporterVersion);

			// XMI.metamodel
			Element metamodel = doc.createElement("XMI.metamodel");

			// xmi.name
			Attr name = doc.createAttribute("xmi.name");
			name.setValue("UML");
			metamodel.setAttributeNode(name);

			// xmi.version
			version = doc.createAttribute("xmi.version");
			version.setValue("1.4");
			metamodel.setAttributeNode(version);

			head.appendChild(metamodel);

			// XMI.content
			Element content = doc.createElement("XMI.content");
			root.appendChild(content);

			// UML:Model
			Element model = doc.createElement("UML:Model");

			// xmi.id
			Attr id = doc.createAttribute("xmi.id");
			id.setValue("estoriaUsuario");
			model.setAttributeNode(id);

			// name
			name = doc.createAttribute("name");
			name.setValue("estoriaUsuario");
			model.setAttributeNode(name);

			// isSpecification
			Attr isSpecification = doc.createAttribute("isSpecification");
			isSpecification.setValue("false");
			model.setAttributeNode(isSpecification);

			// isRoot
			Attr isRoot = doc.createAttribute("isRoot");
			isRoot.setValue("false");
			model.setAttributeNode(isRoot);

			// isLeaf
			Attr isLeaf = doc.createAttribute("isLeaf");
			isLeaf.setValue("false");
			model.setAttributeNode(isLeaf);

			// isAbstract
			Attr isAbstract = doc.createAttribute("isAbstract");
			isAbstract.setValue("false");
			model.setAttributeNode(isAbstract);

			content.appendChild(model);

			// UML:Namespace.ownedElement
			Element ownedElement = doc
					.createElement("UML:Namespace.ownedElement");
			model.appendChild(ownedElement);

			// ------ Diagrama de Classes -------- //

			for (String key : this.diagramaDeClasse.getDiagramaDeClasse()
					.keySet()) {

				// UML:Class
				Element classe = doc.createElement("UML:Class");

				// xmi.id
				id = doc.createAttribute("xmi.id");
				id.setValue(key);
				classe.setAttributeNode(id);

				// name
				name = doc.createAttribute("name");
				name.setValue(key);
				classe.setAttributeNode(name);

				// visibility
				Attr visibility = doc.createAttribute("visibility");
				visibility.setValue("public");
				classe.setAttributeNode(visibility);

				// isSpecification
				isSpecification = doc.createAttribute("isSpecification");
				isSpecification.setValue("false");
				classe.setAttributeNode(isSpecification);

				// isRoot
				isRoot = doc.createAttribute("isRoot");
				isRoot.setValue("false");
				classe.setAttributeNode(isRoot);

				// isLeaf
				isLeaf = doc.createAttribute("isLeaf");
				isLeaf.setValue("false");
				classe.setAttributeNode(isLeaf);

				// isAbstract
				isAbstract = doc.createAttribute("isAbstract");
				isAbstract.setValue("false");
				classe.setAttributeNode(isAbstract);

				// isActive
				Attr isActive = doc.createAttribute("isActive");
				isActive.setValue("false");
				classe.setAttributeNode(isActive);

				ownedElement.appendChild(classe);

				// UML:Classifier.feature
				Element feature = doc.createElement("UML:Classifier.feature");
				classe.appendChild(feature);

				for (String value : this.diagramaDeClasse.getDiagramaDeClasse()
						.get(key)) {

					if (value.contains("_")) {
						String[] atributo = value.split("_");

						// Selecionar o tipo de dado correto
						switch (atributo[0]) {
						case "String":
							tipoDado = "http://argouml.org/profiles/uml14/default-uml14.xmi#-84-17--56-5-43645a83:11466542d86:-8000:000000000000087E";
							break;

						case "Integer":
							tipoDado = "http://argouml.org/profiles/uml14/default-uml14.xmi#-84-17--56-5-43645a83:11466542d86:-8000:000000000000087C";
							break;

						case "Boolean":
							tipoDado = "http://argouml.org/profiles/uml14/default-uml14.xmi#-84-17--56-5-43645a83:11466542d86:-8000:0000000000000880";
							break;

						default:
							break;
						}

						// UML:Attribute
						Element attribute = doc.createElement("UML:Attribute");

						// xmi.id
						id = doc.createAttribute("xmi.id");
						id.setValue(atributo[1] + key);
						attribute.setAttributeNode(id);

						// name
						name = doc.createAttribute("name");
						name.setValue(atributo[1]);
						attribute.setAttributeNode(name);

						// visibility
						visibility = doc.createAttribute("visibility");
						visibility.setValue("private");
						attribute.setAttributeNode(visibility);

						// isSpecification
						isSpecification = doc
								.createAttribute("isSpecification");
						isSpecification.setValue("false");
						attribute.setAttributeNode(isSpecification);

						// ownerScope
						Attr ownerScope = doc.createAttribute("ownerScope");
						ownerScope.setValue("instance");
						attribute.setAttributeNode(ownerScope);

						// changeability
						Attr changeability = doc
								.createAttribute("changeability");
						changeability.setValue("changeable");
						attribute.setAttributeNode(changeability);

						// targetScope
						Attr targetScope = doc.createAttribute("targetScope");
						targetScope.setValue("instance");
						attribute.setAttributeNode(targetScope);

						feature.appendChild(attribute);

						// UML:StructuralFeature.type
						Element type = doc
								.createElement("UML:StructuralFeature.type");
						attribute.appendChild(type);

						// UML:DataType
						Element dataType = doc.createElement("UML:DataType");

						// href
						Attr href = doc.createAttribute("href");
						href.setValue(tipoDado);
						dataType.setAttributeNode(href);

						type.appendChild(dataType);

						// Método
					} else {
						String[] metodo = value.split("\\(");
						metodo[1] = metodo[1].replace(")", "");

						String[] parametro = metodo[1].split(" ");
						metodo[1] = null;

						// UML:Operation
						Element operation = doc.createElement("UML:Operation");

						// xmi.id
						id = doc.createAttribute("xmi.id");
						id.setValue(metodo[0] + parametro[0]);
						operation.setAttributeNode(id);

						// name
						name = doc.createAttribute("name");
						name.setValue(metodo[0]);
						operation.setAttributeNode(name);

						// visibility
						visibility = doc.createAttribute("visibility");
						visibility.setValue("public");
						operation.setAttributeNode(visibility);

						// isSpecification
						isSpecification = doc
								.createAttribute("isSpecification");
						isSpecification.setValue("false");
						operation.setAttributeNode(isSpecification);

						// ownerScope
						Attr ownerScope = doc.createAttribute("ownerScope");
						ownerScope.setValue("instance");
						operation.setAttributeNode(ownerScope);

						// isQuery
						Attr isQuery = doc.createAttribute("isQuery");
						isQuery.setValue("false");
						operation.setAttributeNode(isQuery);

						// concurrency
						Attr concurrency = doc.createAttribute("concurrency");
						concurrency.setValue("sequential");
						operation.setAttributeNode(concurrency);

						// isRoot
						isRoot = doc.createAttribute("isRoot");
						isRoot.setValue("false");
						operation.setAttributeNode(isRoot);

						// isLeaf
						isLeaf = doc.createAttribute("isLeaf");
						isLeaf.setValue("false");
						operation.setAttributeNode(isLeaf);

						// isAbstract
						isAbstract = doc.createAttribute("isAbstract");
						isAbstract.setValue("false");
						operation.setAttributeNode(isAbstract);

						feature.appendChild(operation);

						// UML:BehavioralFeature.parameter
						Element parameter = doc
								.createElement("UML:BehavioralFeature.parameter");
						operation.appendChild(parameter);

						// UML:Parameter
						Element umlParameter = doc
								.createElement("UML:Parameter");

						// xmi.id
						id = doc.createAttribute("xmi.id");
						id.setValue("umlParameter" + indice);
						umlParameter.setAttributeNode(id);

						// name
						name = doc.createAttribute("name");
						name.setValue(parametro[1]);
						umlParameter.setAttributeNode(name);

						// isSpecification
						isSpecification = doc
								.createAttribute("isSpecification");
						isSpecification.setValue("false");
						umlParameter.setAttributeNode(isSpecification);

						// kind
						Attr kind = doc.createAttribute("kind");
						kind.setValue("in");
						umlParameter.setAttributeNode(kind);

						parameter.appendChild(umlParameter);

						// UML:Parameter.type
						Element type = doc.createElement("UML:Parameter.type");
						umlParameter.appendChild(type);

						// UML:Class
						Element umlClasse = doc.createElement("UML:Class");

						// xmi.idref
						Attr idref = doc.createAttribute("xmi.idref");
						idref.setValue(parametro[0]);
						umlClasse.setAttributeNode(idref);

						type.appendChild(umlClasse);

					}
				}
			}

			indice = 0;

			for (String key : this.diagramaDeClasse.getRelacionamento()
					.keySet()) {

				for (String value : this.diagramaDeClasse.getRelacionamento()
						.get(key)) {

					String[] relacionamento = value.split(":");

					// UML:Association
					Element association = doc.createElement("UML:Association");

					// xmi.id
					id = doc.createAttribute("xmi.id");
					id.setValue(relacionamento[0] + relacionamento[1]);
					association.setAttributeNode(id);

					// name
					name = doc.createAttribute("name");
					name.setValue("");
					association.setAttributeNode(name);

					// isSpecification
					isSpecification = doc.createAttribute("isSpecification");
					isSpecification.setValue("false");
					association.setAttributeNode(isSpecification);

					// isRoot
					isRoot = doc.createAttribute("isRoot");
					isRoot.setValue("false");
					association.setAttributeNode(isRoot);

					// isLeaf
					isLeaf = doc.createAttribute("isLeaf");
					isLeaf.setValue("false");
					association.setAttributeNode(isLeaf);

					// isAbstract
					isAbstract = doc.createAttribute("isAbstract");
					isAbstract.setValue("false");
					association.setAttributeNode(isAbstract);

					ownedElement.appendChild(association);

					// UML:Association.connection
					Element connection = doc
							.createElement("UML:Association.connection");
					association.appendChild(connection);

					for (int i = 0; i < relacionamento.length; i++) {

						// UML:AssociationEnd
						Element associationEnd = doc
								.createElement("UML:AssociationEnd");

						// xmi.id
						id = doc.createAttribute("xmi.id");
						id.setValue("associationEnd" + indice);
						associationEnd.setAttributeNode(id);

						// visibility
						Attr visibility = doc.createAttribute("visibility");
						visibility.setValue("private");
						associationEnd.setAttributeNode(visibility);

						// isSpecification
						isSpecification = doc
								.createAttribute("isSpecification");
						isSpecification.setValue("false");
						associationEnd.setAttributeNode(isSpecification);

						// isNavigable
						Attr isNavigable = doc.createAttribute("isNavigable");
						isNavigable.setValue("true");
						associationEnd.setAttributeNode(isNavigable);

						// ordering
						Attr ordering = doc.createAttribute("ordering");
						ordering.setValue("unordered");
						associationEnd.setAttributeNode(ordering);

						// aggregation
						Attr aggregation = doc.createAttribute("aggregation");
						aggregation.setValue("none");
						associationEnd.setAttributeNode(aggregation);

						// targetScope
						Attr targetScope = doc.createAttribute("targetScope");
						targetScope.setValue("instance");
						associationEnd.setAttributeNode(targetScope);

						// changeability
						Attr changeability = doc
								.createAttribute("changeability");
						changeability.setValue("changeable");
						associationEnd.setAttributeNode(changeability);

						connection.appendChild(associationEnd);

						// UML:AssociationEnd.multiplicity
						Element associationEndMultiplicity = doc
								.createElement("UML:AssociationEnd.multiplicity");
						associationEnd.appendChild(associationEndMultiplicity);

						// UML:Multiplicity
						Element multiplicity = doc
								.createElement("UML:Multiplicity");

						// xmi.id
						id = doc.createAttribute("xmi.id");
						id.setValue("multiplicity" + indice);
						multiplicity.setAttributeNode(id);

						associationEndMultiplicity.appendChild(multiplicity);

						// UML:Multiplicity.range
						Element range = doc
								.createElement("UML:Multiplicity.range");
						multiplicity.appendChild(range);

						// UML:MultiplicityRange
						Element multiplicityRange = doc
								.createElement("UML:MultiplicityRange");

						// xmi.id
						id = doc.createAttribute("xmi.id");
						id.setValue("multiplicityRange" + indice);
						multiplicityRange.setAttributeNode(id);

						// lower
						Attr lower = doc.createAttribute("lower");
						lower.setValue("1");
						multiplicityRange.setAttributeNode(lower);

						// upper
						Attr upper = doc.createAttribute("upper");

						// Verifica o tipo de relacionamento
						if (key.equals("1:n") && i == 1) {
							upper.setValue("-1");
						} else {
							upper.setValue("1");
						}

						multiplicityRange.setAttributeNode(upper);

						range.appendChild(multiplicityRange);

						// UML:AssociationEnd.participant
						Element participant = doc
								.createElement("UML:AssociationEnd.participant");
						associationEnd.appendChild(participant);

						// UML:Class
						Element classe = doc.createElement("UML:Class");

						// xmi.idref
						Attr idref = doc.createAttribute("xmi.idref");
						idref.setValue(relacionamento[i]);
						classe.setAttributeNode(idref);

						participant.appendChild(classe);
						indice++;
					}

				}

			}

			// Cria os objetos que fazem referências à console e ao arquivo
			criaEstruturaXMI(doc, 12);

		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}

	private void criaEstruturaXMI(Document doc, int versao)
			throws TransformerException {

		// Cria os objetos que fazem referências à console e ao arquivo
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.newTransformer();

		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);

		// StreamResult console = new StreamResult(System.out);

		StringWriter file = new StringWriter();

		// faz a transformação dos dados para arquivo e para a console!
		// transformer.transform(source, console);
		transformer.transform(source, new StreamResult(file));

		if (versao == 21) {
			this.estoriaXmi21 = String.valueOf(file);
		} else {
			this.estoriaXmi12 = String.valueOf(file);
		}

	}

	public void downloadXMI(HttpServletRequest request,
			HttpServletResponse response, int versao) {

		try {
			String caminhoArquivo = "/resources/arquivos/xmi" + versao + ".xmi";

			// retorna o caminho absoluto da aplicação
			ServletContext context = request.getServletContext();
			String caminhoAplicacao = context.getRealPath("");

			// constroi o caminho absoluto do arquivo e cria o arquivo
			String caminho = caminhoAplicacao + caminhoArquivo;
			File arquivo = new File(caminho);

			// Escreve no arquivo
			FileOutputStream outputStream;

			outputStream = new FileOutputStream(arquivo);

			if (versao == 21) {
				outputStream.write(this.estoriaXmi21.getBytes());
			} else {
				outputStream.write(this.estoriaXmi12.getBytes());
			}

			outputStream.close();

			// realiza o download do arquivo quando clica em download
			InputStream inputStream = new FileInputStream(arquivo);

			response.setContentType("application/force-download");
			response.setHeader("Content-Disposition", "attachment; filename="
					+ arquivo.getName());
			IOUtils.copy(inputStream, response.getOutputStream());

			response.flushBuffer();
			inputStream.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}