<?php
	class Table{

		public $ID;
		public $Store;
		public $Capacity;
		public $Availability;

		function __construct($ID,$Store,$Capacity,$Availability){
			$this->ID = $ID;
			$this->Store = $Store;
			$this->Capacity = $Capacity;			
			$this->Availability = $Availability;
		}

		public function updateAvailability($newAvailability){
			$this->Availability = $newAvailability;
		}
	}
?>
