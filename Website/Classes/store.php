<?php
	class Store{

		public $ID;
		public $Name;
		public $Owner;
		public $Capacity;
		public $CurrentAvailability;
		public $Description;
		public $Visible;
		public $Type;
		public $x;
		public $y;
		public $Tables = array();
		public $Events = array();
		public $Reviews = array();
		public $Reservations = array();

		function __construct($ID, $Name, $Owner, $Capacity, $CurrentAvailability, $Description, $Visible, $Type, $x, $y){
			$this->ID = $ID;
			$this->Name = $Name;
			$this->Owner = $Owner;
			$this->Capacity = $Capacity;
			$this->CurrentAvailability = $CurrentAvailability;
			$this->Description = $Description;
			$this->Visible = $Visible;
			$this->Type = $Type;
			$this->x = $x;
			$this->y = $y;
		}
	}
?>