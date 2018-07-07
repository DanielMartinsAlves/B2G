package Utilidades;

public enum PositionEletrodes {
	Nz("Nz"),
	Fpz("Fpz"), Fp1("Fp1"), Fp2("Fp2"),
	AF7("AF7"), AF3("AF3"), AFz("AFz"), AF4("AF4"), AF8("AF8"),
	Fz("Fz"),F1("F1"),F2("F2"),F3("F3"),F4("F4"),F5("F5"),F6("F6"),F7("F7"),F8("F8"),F9("F9"),F10("F10"), 
	FCz("FCz"),FC1("FC1"), FC2("FC2"), FC3("FC3"), FC4("FC4"), FC5("FC5"), FC6("FC6"),FT7("FT7"), FT8("FT8"), FT9("FT9"), FT10("FT10"),
	Cz("Cz"), C1("C1"), C2("C2"), C3("C3"), C4("C4"), C5("C5"), C6("C6"), T7("T7"), T8("T8"), T9("T9"), T10("T10"), A1("A1"), A2("A2"),
	CPz("CPz"), CP1("CP1"), CP2("CP2"), CP3("CP3"), CP4("CP4"), CP5("CP5"), CP6("CP6"), TP7("TP7"), TP8("TP8"), TP9("TP9"), TP10("TP10"),
	Pz("Pz"), P1("P1"), P2("P2"), P3("P3"), P4("P4"), P5("P5"), P6("P6"), P7("P7"), P8("P8"), P9("P9"), P10("P10"),
	POz("POz"), PO3("PO3"), PO4("PO4"), PO7("PO7"), PO8("PO8"),
	Oz("Oz"), O1("O1"), O2("O2"),
	Iz("Iz");
	
	 public String texto;
	 PositionEletrodes(String texto) {
	        this.texto = texto;
	    }
}
