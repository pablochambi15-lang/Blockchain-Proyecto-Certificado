// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract Certificado {

    struct Certificate {
        string studentName;
        string courseName;
        string institutionName;
        uint256 issueDate;
        string certificateHash;
        address issuedBy;
        bool exists;
    }

    mapping(string => Certificate) private certificates;

    event CertificateIssued(
        string certificateId,
        string studentName,
        string courseName,
        uint256 issueDate,
        address issuedBy
    );

    function issueCertificate(
        string memory _certificateId,
        string memory _studentName,
        string memory _courseName,
        string memory _institutionName,
        uint256 _issueDate,
        string memory _certificateHash
    ) public {

        require(
            !certificates[_certificateId].exists,
            "Certificate already exists"
        );

        certificates[_certificateId] = Certificate({
            studentName: _studentName,
            courseName: _courseName,
            institutionName: _institutionName,
            issueDate: _issueDate,
            certificateHash: _certificateHash,
            issuedBy: msg.sender,
            exists: true
        });

        emit CertificateIssued(
            _certificateId,
            _studentName,
            _courseName,
            _issueDate,
            msg.sender
        );
    }

    function verifyCertificate(
        string memory _certificateId
    )
        public
        view
        returns (
            string memory,
            string memory,
            string memory,
            uint256,
            string memory,
            address
        )
    {

        require(
            certificates[_certificateId].exists,
            "Certificate does not exist"
        );

        Certificate memory cert = certificates[_certificateId];

        return (
            cert.studentName,
            cert.courseName,
            cert.institutionName,
            cert.issueDate,
            cert.certificateHash,
            cert.issuedBy
        );
    }
}