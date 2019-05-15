<?php
	class Reservation{

		public $ID;
		public $SubmittedBy;
		public $Store;
		public $State;
		public $Tables = array();

		function __construct($ID,$SubmittedBy,$Store,$State,$Tables){
			$this->ID = $ID;
			$this->SubmittedBy = $SubmittedBy;
			$this->Store = $Store;
			$this->State = $State;
			$this->Tables = $Tables;
		}

		public function Delete(){
			unset($this->ID);
			unset($this->SubmittedBy);
			unset($this->Store);
			unset($this->State);
			unset($this->Tables);
		}
	}
?>