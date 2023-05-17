package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import matheus.ListaObject.ListaObject;
import model.Num;

public class EspalhamentoControll 
{
	
	private ListaObject[] lista;
	
	public EspalhamentoControll()
	{
		lista = new ListaObject[100];
		iniciaLista();
	}
	
	private void iniciaLista()
	{
		int tamanho = lista.length;
		for (int i = 0; i < tamanho; i++)
		{
			lista[i] = new ListaObject();
		}
	}
	
	public void chamadaCsv() throws Exception
	{
		
		File arq = new File("C:\\TEMP", "EspalhamentoVet.csv");
		
		FileInputStream abreFlux = new FileInputStream(arq);
		InputStreamReader lerFlux = new InputStreamReader(abreFlux);
		BufferedReader buffer = new BufferedReader(lerFlux);
		String linha = buffer.readLine();
		
		String vet[] = linha.split(";");
		int tamanho = vet.length;
		
		for (int i = 0; i < tamanho; i++)
		{
			vet[i] = vet[i].replaceAll("[^0-9]", "");
			Num numero = new Num(Integer.parseInt(vet[i]));
			int posicao = numero.hashCode();
			
			if(lista[posicao].isEmpty())
			{
				lista[posicao].addFirst(numero);
			}
			else
			{
				lista[posicao].addLast(numero);
			}
			
		}
		
		
		buffer.close();
		lerFlux.close();
		abreFlux.close();
		
	}
	
	public void listar() throws Exception
	{
		int tamanho = lista.length;
		
		for (int i = 0; i < tamanho; i++)
		{
			int tamanho1 = lista[i].size();
			for (int j = 0; j < tamanho1; j++)
			{
				Num n = (Num) lista[i].get(j);
				System.out.println(n.toString());
				
			}
			
			
		}
		
		
		
	}
	
	
}
