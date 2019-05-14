<?php
	class Events{

		public $ID;
		public $Store;
		public $Capacity;
		public $CurrentAvailability;
		public $StartDate;
		public $EndDate;

		function __construct($ID,$Store,$Capacity,$CurrentAvailability,$StartDate,$EndDate){
			$this->ID = $ID;
			$this->Capacity = $Capacity;
			$this->Store = $Store;
			$this->CurrentAvailability = $CurrentAvailability;
			$this->StartDate = $StartDate;
			$this->EndDate = $EndDate;
		}
	}
?>
