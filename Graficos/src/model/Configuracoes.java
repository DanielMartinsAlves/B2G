package model;

import java.io.File;

public class Configuracoes {
	private int tempoAtualizacao;
	private int registrosPorGrafo;
	private double limiar;
	private int tipoDeMetrica;
	private int tipoGrafo;
	private int registrosPorAtualizacao;
	private File arquivoLeitura;
	private boolean exportData;
	private String fileName;
	private boolean CARfilter;
	private int nodesNumber;
	private boolean fromOpenBCI;
	public boolean isFromOpenBCI() {
		return fromOpenBCI;
	}
	public void setFromOpenBCI(boolean fromOpenBCI) {
		this.fromOpenBCI = fromOpenBCI;
	}
	public int getNodesNumber() {
		return nodesNumber;
	}
	public void setNodesNumber(int nodesNumber) {
		this.nodesNumber = nodesNumber;
	}
	public boolean isCARfilter() {
		return CARfilter;
	}
	public void setCARfilter(boolean cARfilter) {
		CARfilter = cARfilter;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public boolean isExportData() {
		return exportData;
	}
	public void setExportData(boolean exportData) {
		this.exportData = exportData;
	}
	public File getArquivoLeitura() {
		return arquivoLeitura;
	}
	public void setArquivoLeitura(File arquivoLeitura) {
		this.arquivoLeitura = arquivoLeitura;
	}
	public int getRegistrosPorAtualizacao() {
		return registrosPorAtualizacao;
	}
	public void setRegistrosPorAtualizacao(int registrosPorAtualizacao) {
		this.registrosPorAtualizacao = registrosPorAtualizacao;
	}
	public int getTipoGrafo() {
		return tipoGrafo;
	}
	public void setTipoGrafo(int tipoGrafo) {
		this.tipoGrafo = tipoGrafo;
	}
	public int getTipoDeMetrica() {
		return tipoDeMetrica;
	}
	public void setTipoDeMetrica(int tipoDeMetrica) {
		this.tipoDeMetrica = tipoDeMetrica;
	}
	public double getLimiar() {
		return limiar;
	}
	public void setLimiar(double limiar) {
		this.limiar = limiar;
	}
	private boolean pararGrafo;
	public boolean isPararGrafo() {
		return pararGrafo;
	}
	public void setPararGrafo(boolean pararGrafo) {
		this.pararGrafo = pararGrafo;
	}
	public int getTempoAtualizacao() {
		return tempoAtualizacao;
	}
	public void setTempoAtualizacao(int tempoAtualizacao) {
		this.tempoAtualizacao = tempoAtualizacao;
	}
	public int getRegistrosPorGrafo() {
		return registrosPorGrafo;
	}
	public void setRegistrosPorGrafo(int registrosPorGrafo) {
		this.registrosPorGrafo = registrosPorGrafo;
	}
}
