<?php
	class Report{

		public $ID;
		public $SubmittedBy;
		public $Target;
		public $Description;
		public $Claim;
		public $Claims = array();

		function __construct($ID,$SubmittedBy,$Target,$Description,$Claim,$Claims){
			$this->ID = $ID;
			$this->SubmittedBy = $SubmittedBy;
			$this->Target = $Target;
			$this->Description = $Description;
			$this->Claim = $Claim;
			$this->Claims = $Claims;
		}
	}
?>