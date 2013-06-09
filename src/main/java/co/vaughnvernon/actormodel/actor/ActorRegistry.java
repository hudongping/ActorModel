//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package co.vaughnvernon.actormodel.actor;

import co.vaughnvernon.actormodel.message.Message;

/**
 * Defines a registry for Actors.
 *
 * @author Vaughn Vernon
 */
public interface ActorRegistry extends ActorFinder {

	/**
	 * Answers an ActorAgent for anActor.
	 * @param anActor the Actor for which to create an ActorAgent
	 * @return ActorAgent
	 */
	public ActorAgent actorAgentFor(Actor anActor);

	/**
	 * Answers an ActorAgent for the new Actor of type anActorType.
	 * @param anActorType the Class<? extends Actor> of the Actor to create
	 * @return ActorAgent
	 */
	public ActorAgent actorFor(Class<? extends Actor> anActorType);

	/**
	 * Answers an ActorAgent for the new Actor of type anActorType that is
	 * initialized with anInitalizer.
	 * @param anActorType the Class<? extends Actor> of the Actor to create
	 * @param anInitalizer the ActorInitializer used to initialize the Actor being created
	 * @return ActorAgent
	 */
	public ActorAgent actorFor(Class<? extends Actor> anActorType, ActorInitializer anInitalizer);

	/**
	 * Answers the ActorAgent of the existing Actor registered as anActorType and anAddress.
	 * @param anActorType the Class<? extends Actor> of the existing Actor
	 * @param anAddress the Address of the existing Actor
	 * @return ActorAgent
	 */
	public ActorAgent actorRegisteredAs(Class<? extends Actor> anActorType, Address anAddress);

	/**
	 * Deregister a registered Actor by reference to its ActorAgent.
	 * @param anActorAgent the ActorAgent reference by which the Actor is deregistered
	 */
	public void deregister(ActorAgent anActorAgent);

	/**
	 * Asserts that one message of aMessageType was logged.
	 * @param aMessageType the Class type of the expected message
	 */
	public void expectedMessage(Class<? extends Message> aMessageType);

	/**
	 * Asserts that aTotal messages of aMessageType were logged.
	 * @param aMessageType the Class type of the expected messages
	 */
	public void expectedMessage(Class<? extends Message> aMessageType, int aTotal);

	/**
	 * Asserts that aTotal messages were logged.
	 */
	public void expectedMessages(int aTotal);

	/**
	 * Logs aMessage for later tracing.
	 * @param aMessage the Message to log
	 */
	public void log(Message aMessage);

	/**
	 * Answers a new instance of an Address, which is generated by my AddressFactory.
	 * @return Address
	 */
	public Address newAddress();

	/**
	 * Answers a new instance of an ActorInitializer.
	 * @return ActorInitializer
	 */
	public ActorInitializer newActorInitializer();

	/**
	 * Shuts down the Actor system.
	 */
	public void shutDown();
}
