import React, { useEffect, useState } from "react";
import CustomerService from "../../services/CustomerService";
import { Link } from "react-router-dom";
import Plus from "@iconscout/react-unicons/icons/uil-plus-circle";

const CustomersList = () => {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    getAllCustomers();
  }, []);

  const getAllCustomers = () => {
    CustomerService.getAllCustomers()
      .then((response) => {
        setCustomers(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteCustomer = (customerId) => {
    CustomerService.deleteCustomer(customerId)
      .then((response) => {
        getAllCustomers();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div>
      <h2 className="text-center"> List Customers </h2>
      <Link to="/add-customer" className="btn btn-primary mb-2">
        {" "}
        <Plus />
        Add Customer{" "}
      </Link>
      <table className="table table-bordered table-striped">
        <thead>
          <tr>
            <th> ID </th>
            <th> First Name </th>
            <th> Last Name </th>
            <th> Email </th>
            <th> Actions </th>
          </tr>
        </thead>
        <tbody>
          {customers.map((customer) => (
            <tr key={customer.id}>
              <td> {customer.id} </td>
              <td> {customer.firstName} </td>
              <td> {customer.lastname} </td>
              <td> {customer.email} </td>
              <td>
                <Link
                  className="btn btn-info text-white"
                  to={`/edit-customer/${customer.id}`}
                >
                  Update
                </Link>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteCustomer(customer.id)} 
                >
                  {" "}
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CustomersList;
