package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

public class RepositorioDocumentoImpl implements RepositorioDocumento {

	private List<Documento> documentos = new ArrayList<>();
	private static final Logger Logger = LoggerFactory.getLogger(RepositorioDocumentoImpl.class);
	FileWriter file;
	PrintWriter pw;

	@Override
	public void altaDocumento(Documento documento) {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());

		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}

		documentos.add(documento);
		Logger.info(documento.toString() + " se ha creado correctamente");
		Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void altaDocumentoConArchivo(Documento documento) {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());

		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}

		documentos.add(documento);
		try {
			file = new FileWriter("Alta.txt", true);
			pw = new PrintWriter(file);
			pw.println(documento.getDatos());
			pw.println("********************");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Logger.info(documento.toString() + " se ha creado correctamente");
		Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void modificarDocumento(Documento documento) {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}

		documentos.set(documentos.indexOf(documento), documento);
		Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void modificarDocumentoConArchivo(Documento documento, Documento documentoNuevo) {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento a modificar no existe");
		}

		documentos.set(documentos.indexOf(documento), documentoNuevo);
		try {
			file = new FileWriter("Modificar.txt", true);
			pw = new PrintWriter(file);
			pw.println(documentoNuevo.getDatos());
			pw.println("********************");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Override
	public void eliminarDocumento(Integer codigo) {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		final Documento documentoAEliminar = this.obtenerDocumentoPorCodigo(codigo);
		Logger.info("Eliminando " + documentoAEliminar.toString());

		if (Objects.nonNull(documentoAEliminar)) {
			documentos.remove(documentoAEliminar);
			Logger.info(documentoAEliminar.toString() + " se ha eliminado");
			Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}

	@Override
	public void eliminarDocumentoConArchivo(Integer codigo) {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		final Documento documentoAEliminar = this.obtenerDocumentoPorCodigo(codigo);
		Logger.info("Eliminando " + documentoAEliminar.toString());

		if (Objects.nonNull(documentoAEliminar)) {
			documentos.remove(documentoAEliminar);
			try {
				file = new FileWriter("Eliminar.txt", true);
				pw = new PrintWriter(file);
				pw.println(documentoAEliminar.getDatos());
				pw.println("********************");
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Logger.info(documentoAEliminar.toString() + " se ha eliminado");
			Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		}
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Logger.info("Buscando documento con codigo " + codigo);
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			Logger.info("Documento con codigo " + codigo + " encontrado. ");
			documentoEncontrado.get().getDatos();
			Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
			return documentoEncontrado.get();
		}
		Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return null;
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		for (Documento doc : documentos) {
			Logger.info("************************");
			Logger.info(this.getDatos(doc));
			Logger.info("************************");
		}
		Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
		return this.documentos;
	}

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {

		return documento.getCodigo().equals(codigo);
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public String getDatos(Documento documento) {
		return "Documento con código" + documento.getCodigo() + " Nombre:  " + documento.getNombre() + " FechaCracion: "
				+ documento.getFechaCreacion() + " FechaUltimaActualizacion: " + documento.getFechaUltimaActualizacion()
				+ " Publico: " + documento.getPublico() + ".";
	}

	@Override
	public void GuardarDocumentoEnArchivo() {
		Logger.info("Entrando en metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());

		for (Documento documento : documentos) {

			try {
				file = new FileWriter("documentos.txt", true);
				pw = new PrintWriter(file);
				pw.println(documento.getDatos());
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			file = new FileWriter("documentos.txt", true);
			pw = new PrintWriter(file);
			pw.println("**********************");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Logger.info("Saliendo de metodo " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	public static boolean exportarExcel(String nombreHoja, Map<String, Object[]> data, String fileName) {

		// Creamos el libro de trabajo
		XSSFWorkbook libro = new XSSFWorkbook();

		// Creacion de Hoja
		XSSFSheet hoja = libro.createSheet(nombreHoja);

		// Iteramos el map e insertamos los datos
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// creamos la fila
			Row row = hoja.createRow(rownum++);
			// obtenemos los datos de la fila
			Object[] objArr = data.get(key);
			int cellnum = 0;
			// iteramos cada dato de la fila
			for (Object obj : objArr) {
				// Creamos la celda
				Cell cell = row.createCell(cellnum++);
				// Setteamos el valor con el tipo de dato correspondiente
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Escribimos en fichero
			FileOutputStream out = new FileOutputStream(new File(fileName));
			libro.write(out);
			// cerramos el fichero y el libro
			out.close();
			libro.close();
			System.out.println("Excel exportado correctamente\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<String[]> importarExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
		ArrayList<String[]> data = new ArrayList<>();

		try {
			// Acceso al fichero xlsx
			FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtenemos la primera hoja
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterador de filas
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Iterador de celdas
				Iterator<Cell> cellIterator = row.cellIterator();
				// contador para el array donde guardamos los datos de cada fila
				int contador = 0;
				// Array para guardar los datos de cada fila
				// y añadirlo al ArrayList
				String[] fila = new String[numColums];
				// iteramos las celdas de la fila
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Guardamos los datos de la celda segun su tipo
					switch (cell.getCellType()) {
					// si es numerico
					case Cell.CELL_TYPE_NUMERIC:
						fila[contador] = (int) cell.getNumericCellValue() + "";
						break;
					// si es cadena de texto
					case Cell.CELL_TYPE_STRING:
						fila[contador] = cell.getStringCellValue() + "";
						break;
					}
					// Si hemos terminado con la ultima celda de la fila
					if ((contador + 1) % numColums == 0) {
						// Añadimos la fila al ArrayList con todos los datos
						data.add(fila);
					}
					// Incrementamos el contador
					// con cada fila terminada al redeclarar arriba el contador,
					// no obtenemos excepciones de ArrayIndexOfBounds
					contador++;
				}
			}
			// Cerramos el fichero y workbook
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Excel importado correctamente\n");

		return data;
	}
}
