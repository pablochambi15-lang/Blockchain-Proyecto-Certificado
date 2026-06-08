package com.Certificados.Pablo.service;



import com.Certificados.Pablo.blockchain.BlockchainConfig;
import com.Certificados.Pablo.blockchain.ContractData;
import com.Certificados.Pablo.blockchain.WalletConfig;
import com.Certificados.Pablo.contracts.Certificado;
import com.Certificados.Pablo.dto.CertificateRequest;
import com.Certificados.Pablo.dto.CertificateResponse;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

@Service
public class BlockchainService {

    public CertificateResponse verificarCertificado(
        String certificateId) throws Exception {

    var resultado =
            contrato.verifyCertificate(certificateId)
                    .send();

    CertificateResponse response =
            new CertificateResponse();

    response.setStudentName(resultado.component1());
    response.setCourseName(resultado.component2());
    response.setInstitutionName(resultado.component3());
    response.setIssueDate(resultado.component4().longValue());
    response.setCertificateHash(resultado.component5());
    response.setIssuedBy(resultado.component6());

    return response;
}
    private final Certificado contrato;

    public BlockchainService() {

        Web3j web3j = BlockchainConfig.getWeb3j();

        contrato = Certificado.load(
            ContractData.CONTRACT_ADDRESS,
                web3j,
                WalletConfig.getCredentials(),
            new StaticGasProvider(
                BigInteger.valueOf(20000000000L),
                BigInteger.valueOf(3000000)
        )
);
    }

    public String emitirCertificado(
        CertificateRequest request) throws Exception {

    TransactionReceipt receipt =
            contrato.issueCertificate(

                    request.getCertificateId(),
                    request.getStudentName(),
                    request.getCourseName(),
                    request.getInstitutionName(),
                    BigInteger.valueOf(System.currentTimeMillis()),
                    request.getCertificateHash()

            ).send();

    return receipt.getTransactionHash();
}
}