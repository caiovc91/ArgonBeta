package caio.systems.argontest;

import android.graphics.pdf.PdfDocument;

public class Enterprise {

    private String companyName;
    private String codContract;
    private  String contract; //näo é um pdf, é um arquivo que será baixado.
    private String cnpj;
    private String dueDate;
    private String contactInfo;

    public Enterprise(String companyName, String codContract, String contract, String cnpj, String dueDate, String contactInfo) {
        this.companyName = companyName;
        this.codContract = codContract;
        this.contract = contract;
        this.cnpj = cnpj;
        this.dueDate = dueDate;
        this.contactInfo = contactInfo;
    }

    public Enterprise(String companyName, String codContract) {
        this.companyName = companyName;
        this.codContract = codContract;
    }

    @Override
    public String toString() {
        return this.companyName;
    }
}
