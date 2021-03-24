import React, {useState} from "react";

function RegForm(props){
    return(
        <div className="card col-12 col-lg-4 login-card mt-2 hv-center">
            <form>
                 <div className="form-group text-left">
                    <label htmlFor="firstNameInput">First Name</label>
                    <input type="text" 
                       className="form-control" 
                       id="firstName" 
                       aria-describedby="test" 
                       placeholder="First Name"
                    />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="lastNameInput">Last Name</label>
                    <input type="text" 
                       className="form-control" 
                       id="lastName" 
                       aria-describedby="test" 
                       placeholder="Last Name"
                    />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="npiNumberInput">NPI number</label>
                    <input type="number" 
                       className="form-control" 
                       id="npiNumber" 
                       aria-describedby="test" 
                       placeholder="NPI number"
                    />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="bussAddrInput">Business Address</label>
                    <input type="text" 
                       className="form-control" 
                       id="bussAddr" 
                       aria-describedby="test" 
                       placeholder="Bussiness Adress"
                    />
                </div>
                <div className="form-group text-left">
                    <label htmlFor="phoneNumInput">Telephone Number</label>
                    <input type="number" 
                       className="form-control" 
                       id="phoneNum" 
                       aria-describedby="test" 
                       placeholder="Telephone Number"
                    />
                </div>
                <div className="form-group text-left">
                <label htmlFor="exampleInputEmail1">Email address</label>
                <input type="email" 
                       className="form-control" 
                       id="email" 
                       aria-describedby="emailHelp" 
                       placeholder="Enter email"
                />
                </div>

                <button 
                    type="submit" 
                    className="btn btn-primary"
                >
                    Register
                </button>
            </form>
        </div>
    )
}
export default RegForm;