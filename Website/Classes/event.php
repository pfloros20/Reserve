<?php
	class Events{

		public $ID;
		public $Name;
		public $Store;
		public $StartDate;
		public $EndDate;
		public $Description;

		function __construct($ID, $Name, $Store, $StartDate, $EndDate, $Description){
			$this->ID = $ID;
			$this->Name = $Name;
			$this->Store = $Store;
			$this->StartDate = $StartDate;
			$this->EndDate = $EndDate;
			$this->Description = $Description;
		}
	}
?>
