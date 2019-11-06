import React, { Component } from "react";

class AddProject extends Component {
	constructor() {
		super();

		this.state = {
			name: "",
			identifier: "",
			description: "",
			startDate: "",
			endDate: ""
		};

		this.onChange = this.onChange.bind(this);
		this.onSubmit = this.onSubmit.bind(this);
	}

	onChange(e) {
		this.setState({ [e.target.name]: e.target.value });
	}

	onSubmit(e) {
		//PREVINE O RELOAD
		e.preventDefault();

		const newProject = {
			name: this.state.name,
			identifier: this.state.identifier,
			description: this.state.description,
			startDate: this.state.startDate,
			endDate: this.state.endDate
		};

		console.log(newProject);
	}

	render() {
		return (
			<div className="project">
				<div className="container">
					<div className="row">
						<div className="col-md-8 m-auto">
							<h5 className="display-4 text-center">Create Project form</h5>
							<hr />
							<form onSubmit={this.onSubmit}>
								<div className="form-group">
									<input
										type="text"
										className="form-control form-control-lg "
										placeholder="Project Name"
										name="name"
										value={this.state.name}
										onChange={this.onChange}
									/>
								</div>
								<div className="form-group">
									<input
										type="text"
										className="form-control form-control-lg"
										placeholder="Unique Project ID"
										name="identifier"
										value={this.state.identifier}
										onChange={this.onChange}
									/>
								</div>
								<div className="form-group">
									<textarea
										className="form-control form-control-lg"
										placeholder="Project Description"
										name="description"
										value={this.state.description}
										onChange={this.onChange}
									></textarea>
								</div>
								<h6>Start Date</h6>
								<div className="form-group">
									<input
										type="date"
										className="form-control form-control-lg"
										name="startDate"
										value={this.state.startDate}
										onChange={this.onChange}
									/>
								</div>
								<h6>Estimated End Date</h6>
								<div className="form-group">
									<input
										type="date"
										className="form-control form-control-lg"
										name="endDate"
										value={this.state.endDate}
										onChange={this.onChange}
									/>
								</div>

								<input
									type="submit"
									className="btn btn-primary btn-block mt-4"
								/>
							</form>
						</div>
					</div>
				</div>
			</div>
		);
	}
}

export default AddProject;
