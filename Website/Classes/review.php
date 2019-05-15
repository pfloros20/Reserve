<?php
	class Review{

		public $ID;
		public $SubmittedBy;
		public $Store;
		public $Stars;
		public $Reports = array();

		function __construct($ID,$SubmittedBy,$Store,$Stars,$Reports){
			$this->ID = $ID;
			$this->SubmittedBy = $SubmittedBy;
			$this->Store = $Store;
			$this->Stars = $Stars;
			$this->Reports = $Reports;
		}
	}
?>