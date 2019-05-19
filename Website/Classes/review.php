<?php
	class Review{

		public $ID;
		public $SubmittedBy;
		public $Store;
		public $Stars;
		public $Description;
		public $Reports = array();

		function __construct($ID, $SubmittedBy, $Store, $Stars, $Description, $Reports){
			$this->ID = $ID;
			$this->SubmittedBy = $SubmittedBy;
			$this->Store = $Store;
			$this->Stars = $Stars;
			$this->Description = $Description;
			$this->Reports = $Reports;
		}
	}
?>