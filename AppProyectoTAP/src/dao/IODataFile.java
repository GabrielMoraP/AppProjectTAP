package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modelo.Catalogo;
import modelo.Producto;
import modelo.Resurtido;
import modelo.Venta;

public class IODataFile {

	public static void writeObjectToFileProducto(String ruta, Catalogo<Producto> lista) {
		FileOutputStream file = null;
		ObjectOutputStream salida = null;
		try {
			file = new FileOutputStream(ruta);
			salida = new ObjectOutputStream(file);
			salida.writeObject(lista);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (salida != null && file != null) {
				try {
					file.close();
					salida.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static Catalogo<Producto> readObjectToFileProducto(String ruta) {
		FileInputStream file = null;
		ObjectInputStream entrada = null;
		try {
			file = new FileInputStream(ruta);
			entrada = new ObjectInputStream(file);
			return (Catalogo<Producto>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}finally {
			if (entrada != null && file != null) {
				try {
					file.close();
					entrada.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return null;
	}
	
	public static void writeObjectToFileResurtido(String ruta, Catalogo<Resurtido> lista) {
		FileOutputStream file = null;
		ObjectOutputStream salida = null;
		try {
			file = new FileOutputStream(ruta);
			salida = new ObjectOutputStream(file);
			salida.writeObject(lista);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (salida != null && file != null) {
				try {
					file.close();
					salida.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static Catalogo<Resurtido> readObjectToFileResurtido(String ruta) {
		FileInputStream file = null;
		ObjectInputStream entrada = null;
		try {
			file = new FileInputStream(ruta);
			entrada = new ObjectInputStream(file);
			return (Catalogo<Resurtido>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}finally {
			if (entrada != null && file != null) {
				try {
					file.close();
					entrada.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return null;
	}
	
	public static void writeObjectToFileVenta(String ruta, Catalogo<Venta> lista) {
		FileOutputStream file = null;
		ObjectOutputStream salida = null;
		try {
			file = new FileOutputStream(ruta);
			salida = new ObjectOutputStream(file);
			salida.writeObject(lista);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (salida != null && file != null) {
				try {
					file.close();
					salida.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static Catalogo<Venta> readObjectToFileVenta(String ruta) {
		FileInputStream file = null;
		ObjectInputStream entrada = null;
		try {
			file = new FileInputStream(ruta);
			entrada = new ObjectInputStream(file);
			return (Catalogo<Venta>) entrada.readObject();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}finally {
			if (entrada != null && file != null) {
				try {
					file.close();
					entrada.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return null;
	}

}
