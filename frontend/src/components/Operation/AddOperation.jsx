import React, {useState, useEffect} from 'react'
import {Link, useHistory, useParams } from 'react-router-dom';
import OperationService from '../../services/OperationService'

const AddOperation = () => {
    

      const [date, setDate] = useState('')
      const [first_name_customer, setFirstNameOperation] = useState('')
      const [last_name_customer, setLastNameOperation] = useState('')
      const [products, setProducts] = useState('')
      const [quantity, setQuantity] = useState('')
      const [total, setTotal] = useState('')
      const history = useHistory();
      const {id} = useParams();
  
      const saveOrUpdateOperation = (e) => {
          e.preventDefault();
  
          const operation = {date, first_name_customer, last_name_customer, products, quantity, total}
  
          if(id){
              OperationService.updateOperation(id, operation).then((response) => {
                  history.push('/operations')
              }).catch(error => {
                  console.log(error)
              })
  
          }else{
              OperationService.createOperation(operation).then((response) =>{
  
                  console.log(response.data)
      
                  history.push('/operations');
      
              }).catch(error => {
                  console.log(error)
              })
          }
          
      }
  
      useEffect(() => {
  
          OperationService.getOperationById(id).then((response) =>{
                setDate(response.data.firstName)
                setFirstNameOperation(response.data.lastname)
                setLastNameOperation(response.data.email)
                setProducts(response.data.firstName)
                setQuantity(response.data.lastname)
                setTotal(response.data.email)
          }).catch(error => {
              console.log(error)
          })
      }, [])
  
      const title = () => {
  
          if(id){
              return <h2 className = "text-center">Update Operation</h2>
          }else{
              return <h2 className = "text-center">Add Operation</h2>
          }
      }
  
      return (
        <div>
          <br />
          <br />
          <div className="container">
            <div className="row">
              <div className="card col-md-6 offset-md-3 offset-md-3">
                {title()}
                <div className="card-body">
                  <form>
                    <div className="form-group mb-2">
                      <label className="form-label"> Date:</label>
                      <input
                        autoFocus
                        type="date"
                        placeholder="Enter date"
                        name="date"
                        className="form-control"
                        value={date}
                        onChange={(e) => setDate(e.target.value)}
                      ></input>
                    </div>

                    <div className="form-group mb-2">
                      <label className="form-label">
                        {" "}
                        Costumer first name:
                      </label>
                      <input
                        type="text"
                        placeholder="Enter customer first name"
                        name="first_name_customer"
                        className="form-control"
                        value={first_name_customer}
                        onChange={(e) => setFirstNameOperation(e.target.value)}
                      ></input>
                    </div>

                    <div className="form-group mb-2">
                      <label className="form-label"> Costumer last name:</label>
                      <input
                        type="text"
                        placeholder="Enter email Id"
                        name="last_name_customer"
                        className="form-control"
                        value={last_name_customer}
                        onChange={(e) => setLastNameOperation(e.target.value)}
                      ></input>
                    </div>

                    <div className="form-group mb-2">
                      <label className="form-label"> Products:</label>
                      <input
                        type="text"
                        placeholder="Enter products"
                        name="products"
                        className="form-control"
                        value={products}
                        onChange={(e) => setProducts(e.target.value)}
                      ></input>
                    </div>

                    <div className="form-group mb-2">
                      <label className="form-label"> Quantity:</label>
                      <input
                        type="number"
                        placeholder="Enter quantity"
                        name="quantity"
                        className="form-control"
                        value={quantity}
                        onChange={(e) => setQuantity(e.target.value)}
                      ></input>
                    </div>

                    <div className="form-group mb-2">
                      <label className="form-label"> Total:</label>
                      <input
                        type="number"
                        placeholder="Enter total"
                        name="quantity"
                        className="form-control"
                        value={quantity}
                        onChange={(e) => setTotal(e.target.value)}
                      ></input>
                    </div>

                    <button className = "btn btn-success" onClick = {(e) => saveOrUpdateOperation(e)} >Submit </button>
                    <Link to="/operations" className="btn btn-danger"> Cancel </Link>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      );
  }
  
  export default AddOperation