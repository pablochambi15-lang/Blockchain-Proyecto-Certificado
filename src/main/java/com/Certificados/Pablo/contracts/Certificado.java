package com.Certificados.Pablo.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.10.3.
 */
@SuppressWarnings("rawtypes")
public class Certificado extends Contract {
    public static final String BINARY = "6080604052348015600e575f5ffd5b506109c88061001c5f395ff3fe608060405234801561000f575f5ffd5b5060043610610034575f3560e01c806377ec128c146100385780638b23d8751461004d575b5f5ffd5b61004b610046366004610621565b61007b565b005b61006061005b36600461070c565b610232565b60405161007296959493929190610774565b60405180910390f35b5f8660405161008a91906107e2565b9081526040519081900360200190206005015460ff600160a01b90910416156100fa5760405162461bcd60e51b815260206004820152601a60248201527f436572746966696361746520616c72656164792065786973747300000000000060448201526064015b60405180910390fd5b6040518060e00160405280868152602001858152602001848152602001838152602001828152602001336001600160a01b03168152602001600115158152505f8760405161014891906107e2565b90815260405190819003602001902081518190610165908261087c565b506020820151600182019061017a908261087c565b506040820151600282019061018f908261087c565b5060608201516003820155608082015160048201906101ae908261087c565b5060a08201516005909101805460c0909301511515600160a01b026001600160a81b03199093166001600160a01b03909216919091179190911790556040517f6ba077869d073ee3b9663b44b50443f6cd48bbddd74d9c3fe14f5a0cc0407335906102229088908890889087903390610937565b60405180910390a1505050505050565b60608060605f60605f5f8760405161024a91906107e2565b9081526040519081900360200190206005015460ff600160a01b909104166102b45760405162461bcd60e51b815260206004820152601a60248201527f436572746966696361746520646f6573206e6f7420657869737400000000000060448201526064016100f1565b5f5f886040516102c491906107e2565b90815260200160405180910390206040518060e00160405290815f820180546102ec906107f8565b80601f0160208091040260200160405190810160405280929190818152602001828054610318906107f8565b80156103635780601f1061033a57610100808354040283529160200191610363565b820191905f5260205f20905b81548152906001019060200180831161034657829003601f168201915b5050505050815260200160018201805461037c906107f8565b80601f01602080910402602001604051908101604052809291908181526020018280546103a8906107f8565b80156103f35780601f106103ca576101008083540402835291602001916103f3565b820191905f5260205f20905b8154815290600101906020018083116103d657829003601f168201915b5050505050815260200160028201805461040c906107f8565b80601f0160208091040260200160405190810160405280929190818152602001828054610438906107f8565b80156104835780601f1061045a57610100808354040283529160200191610483565b820191905f5260205f20905b81548152906001019060200180831161046657829003601f168201915b50505050508152602001600382015481526020016004820180546104a6906107f8565b80601f01602080910402602001604051908101604052809291908181526020018280546104d2906107f8565b801561051d5780601f106104f45761010080835404028352916020019161051d565b820191905f5260205f20905b81548152906001019060200180831161050057829003601f168201915b5050509183525050600591909101546001600160a01b038116602080840191909152600160a01b90910460ff161515604092830152825190830151918301516060840151608085015160a090950151929d939c50909a50985091965090945092505050565b634e487b7160e01b5f52604160045260245ffd5b5f82601f8301126105a5575f5ffd5b813567ffffffffffffffff8111156105bf576105bf610582565b604051601f8201601f19908116603f0116810167ffffffffffffffff811182821017156105ee576105ee610582565b604052818152838201602001851015610605575f5ffd5b816020850160208301375f918101602001919091529392505050565b5f5f5f5f5f5f60c08789031215610636575f5ffd5b863567ffffffffffffffff81111561064c575f5ffd5b61065889828a01610596565b965050602087013567ffffffffffffffff811115610674575f5ffd5b61068089828a01610596565b955050604087013567ffffffffffffffff81111561069c575f5ffd5b6106a889828a01610596565b945050606087013567ffffffffffffffff8111156106c4575f5ffd5b6106d089828a01610596565b9350506080870135915060a087013567ffffffffffffffff8111156106f3575f5ffd5b6106ff89828a01610596565b9150509295509295509295565b5f6020828403121561071c575f5ffd5b813567ffffffffffffffff811115610732575f5ffd5b61073e84828501610596565b949350505050565b5f81518084528060208401602086015e5f602082860101526020601f19601f83011685010191505092915050565b60c081525f61078660c0830189610746565b82810360208401526107988189610746565b905082810360408401526107ac8188610746565b905085606084015282810360808401526107c68186610746565b91505060018060a01b03831660a0830152979650505050505050565b5f82518060208501845e5f920191825250919050565b600181811c9082168061080c57607f821691505b60208210810361082a57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f82111561087757805f5260205f20601f840160051c810160208510156108555750805b601f840160051c820191505b81811015610874575f8155600101610861565b50505b505050565b815167ffffffffffffffff81111561089657610896610582565b6108aa816108a484546107f8565b84610830565b6020601f8211600181146108dc575f83156108c55750848201515b5f19600385901b1c1916600184901b178455610874565b5f84815260208120601f198516915b8281101561090b57878501518255602094850194600190920191016108eb565b508482101561092857868401515f19600387901b60f8161c191681555b50505050600190811b01905550565b60a081525f61094960a0830188610746565b828103602084015261095b8188610746565b9050828103604084015261096f8187610746565b606084019590955250506001600160a01b0391909116608090910152939250505056fea264697066735822122094069653e97d10b2a5c7fe2c858929fb88f0bc3b6fbc987a5ea478646516004064736f6c634300081e0033";

    public static final String FUNC_ISSUECERTIFICATE = "issueCertificate";

    public static final String FUNC_VERIFYCERTIFICATE = "verifyCertificate";

    public static final Event CERTIFICATEISSUED_EVENT = new Event("CertificateIssued", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected Certificado(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Certificado(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Certificado(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Certificado(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<CertificateIssuedEventResponse> getCertificateIssuedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(CERTIFICATEISSUED_EVENT, transactionReceipt);
        ArrayList<CertificateIssuedEventResponse> responses = new ArrayList<CertificateIssuedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CertificateIssuedEventResponse typedResponse = new CertificateIssuedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.certificateId = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.studentName = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.courseName = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.issueDate = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.issuedBy = (String) eventValues.getNonIndexedValues().get(4).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static CertificateIssuedEventResponse getCertificateIssuedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(CERTIFICATEISSUED_EVENT, log);
        CertificateIssuedEventResponse typedResponse = new CertificateIssuedEventResponse();
        typedResponse.log = log;
        typedResponse.certificateId = (String) eventValues.getNonIndexedValues().get(0).getValue();
        typedResponse.studentName = (String) eventValues.getNonIndexedValues().get(1).getValue();
        typedResponse.courseName = (String) eventValues.getNonIndexedValues().get(2).getValue();
        typedResponse.issueDate = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
        typedResponse.issuedBy = (String) eventValues.getNonIndexedValues().get(4).getValue();
        return typedResponse;
    }

    public Flowable<CertificateIssuedEventResponse> certificateIssuedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getCertificateIssuedEventFromLog(log));
    }

    public Flowable<CertificateIssuedEventResponse> certificateIssuedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CERTIFICATEISSUED_EVENT));
        return certificateIssuedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> issueCertificate(String _certificateId, String _studentName, String _courseName, String _institutionName, BigInteger _issueDate, String _certificateHash) {
        final Function function = new Function(
                FUNC_ISSUECERTIFICATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_certificateId), 
                new org.web3j.abi.datatypes.Utf8String(_studentName), 
                new org.web3j.abi.datatypes.Utf8String(_courseName), 
                new org.web3j.abi.datatypes.Utf8String(_institutionName), 
                new org.web3j.abi.datatypes.generated.Uint256(_issueDate), 
                new org.web3j.abi.datatypes.Utf8String(_certificateHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple6<String, String, String, BigInteger, String, String>> verifyCertificate(String _certificateId) {
        final Function function = new Function(FUNC_VERIFYCERTIFICATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_certificateId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        return new RemoteFunctionCall<Tuple6<String, String, String, BigInteger, String, String>>(function,
                new Callable<Tuple6<String, String, String, BigInteger, String, String>>() {
                    @Override
                    public Tuple6<String, String, String, BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, String, String, BigInteger, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue());
                    }
                });
    }

    @Deprecated
    public static Certificado load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Certificado(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Certificado load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Certificado(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Certificado load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Certificado(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Certificado load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Certificado(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Certificado> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Certificado.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Certificado> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Certificado.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Certificado> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Certificado.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Certificado> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Certificado.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CertificateIssuedEventResponse extends BaseEventResponse {
        public String certificateId;

        public String studentName;

        public String courseName;

        public BigInteger issueDate;

        public String issuedBy;
    }
}
