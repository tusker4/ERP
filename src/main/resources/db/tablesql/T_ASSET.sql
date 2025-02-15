DROP TABLE ASSET;

CREATE TABLE ASSET (
	ass_id NUMBER NOT NULL,
	c_id NUMBER NOT NULL,
	ass_stock NUMBER NULL,
	ass_bond NUMBER NULL,
	ass_realestate NUMBER NULL,
	ass_deposit NUMBER NULL,
	ass_savings NUMBER NULL,
	ass_loan NUMBER NULL,
	ass_total NUMBER DEFAULT 0 NULL,
	ass_lastupdate TIMESTAMP(0) NULL,
	CONSTRAINT PK_ASSET PRIMARY KEY (ass_id, c_id),
	CONSTRAINT FK_CUSTOMER_TO_ASSET_1 FOREIGN KEY (c_id) REFERENCES CUSTOMER (c_id)
);

select * from ASSET;

--COMMENT ON COLUMN ASSET.ass_stock IS '수치화';
--COMMENT ON COLUMN ASSET.ass_bond IS '수치화';
--COMMENT ON COLUMN ASSET.ass_realestate IS '수치화';
--COMMENT ON COLUMN ASSET.ass_deposit IS '자동 업데이트';
--COMMENT ON COLUMN ASSET.ass_savings IS '자동 업데이트';
--COMMENT ON COLUMN ASSET.ass_loan IS '수치화';
--COMMENT ON COLUMN ASSET.ass_total IS '자동 업데이트';