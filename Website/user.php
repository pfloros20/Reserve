<?php
	class User{

		public $ID;
		public $Username;
		public $Password;
		public $Reviews = array();
		public $Visited = array();
		public $Reports = array();
		public $CurrentLocation;

		function __construct($ID,$Username,$Password,$Reviews,$Visited,$Reports,$CurrentLocation){
			$this->ID = $ID;
			$this->Username = $Username;
			$this->Password = $Password;
			$this->Reviews = $Reviews;
			$this->Visited = $Visited;
			$this->Reports = $Reports;
			$this->CurrentLocation = $CurrentLocation;
		}

		public function updateHistory($newStore){
			array_unshift($this->Visited,$newStore);
		}
	}
?>